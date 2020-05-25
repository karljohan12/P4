/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2018  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import AST.NonAbstract.Node.Program;
import TypeChecker.TypeCheckerIVisitor;
import CodeGenerator.InoCodeGeneratorIVisitor;
import Scanner.*;
import Parser.*;
import java_cup.runtime.Symbol;


/**
 * Simple test driver for the java parser. Just runs it on some input files, gives no useful output.
 */
public class JavaParser {

    public static void main(String argv[]) {
        argv = new String[]{"Test/parsertest.roboduino", "--verify"};

        String inputFilePath = null;
        String outputFilePath = null;
        boolean verifyCompilation = false;

        switch (argv.length) {
            case 1:
                if (argv[0].equals("--help")) {
                    displayHelp();
                } else {
                    if (isAllowedType(argv[0])) {
                        inputFilePath = argv[0];
                        outputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf("."));
                    } else {
                        displayHelp();
                    }
                }
                break;
            case 2:
                if (argv[1].equals("--verify")) {
                    if (isAllowedType(argv[0])) {
                        inputFilePath = argv[0];
                        outputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf("."));
                        verifyCompilation = true;
                    } else {
                        displayHelp();
                    }
                } else {
                    if (isAllowedType(argv[0])) {
                        outputFilePath = argv[1];
                    } else {
                        displayHelp();
                    }
                }
                break;
            case 3:
                if (isAllowedType(argv[0])) {
                    inputFilePath = argv[0];
                    outputFilePath = argv[1];
                    if (argv[2].equals("--verify")) {
                        verifyCompilation = true;
                    }
                } else {
                    displayHelp();
                }
                break;
            default:
                displayHelp();
        }

        if (inputFilePath != null) {
            try {
                System.out.println("Compiling " + inputFilePath + "...");
                Scanner s = new Scanner(new UnicodeEscapes(new FileReader(inputFilePath)));
                parser p = new parser(s);
                Symbol root = p.parse();
                Program program = (Program) root.value;
                program.accept(new TypeCheckerIVisitor());
                InoCodeGeneratorIVisitor cgv = new InoCodeGeneratorIVisitor();
                program.accept(cgv);

                FileWriter fileWriter = new FileWriter(outputFilePath + ".ino");
                System.out.println("Writing to file " + outputFilePath + ".ino ...");
                fileWriter.write(cgv.code.toString());
                fileWriter.close();
                if (System.getProperty("os.name").startsWith("Windows") && verifyCompilation) {
                    System.out.println("Verifying storage...");
                    verify(outputFilePath);
                }

                System.out.println("Compilation succeeded");
            } catch (Exception e) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
    }

    public static void verify(String outputFilePath) throws RuntimeException, IOException, InterruptedException {
        try {

            String value = WindowsReqistry.readRegistry("HKLM\\SOFTWARE\\Classes\\Arduino file\\shell\\open\\command", "");

            String[] pathArray = value.split("\"");
            int indexOfExe = pathArray[1].indexOf("arduino.exe");
            String path = pathArray[1].substring(0, indexOfExe);
            path = path + "arduino_debug";

            //ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Arduino\\arduino_debug", "--verify", "program.ino");
            ProcessBuilder process = new ProcessBuilder(path, "--verify", outputFilePath + ".ino");
            File temp = new File(System.getProperty("user.dir") + "\\ArduinoStorage.temp");
            process.redirectOutput(temp);

            Process pr = Runtime.getRuntime().exec("attrib +H " + System.getProperty("user.dir") + "\\ArduinoStorage.temp");
            pr.waitFor();

            Process e = process.start();
            BufferedReader in1 = new BufferedReader(new InputStreamReader(e.getErrorStream()));
            while ((in1.readLine()) != null) {
            }
            e.waitFor();

            String storage = Files.readString(Paths.get("ArduinoStorage.temp"));
            temp.delete();
            System.out.println(storage);

            String pattern1 = "(";
            String pattern2 = "%)";
            String text = storage;
            ArrayList<String> percent = new ArrayList<String>();

            Pattern p = Pattern.compile(Pattern.quote(pattern1) + "(.*?)" + Pattern.quote(pattern2));
            Matcher m = p.matcher(text);
            while (m.find()) {
                percent.add(m.group(1));
            }

            if (percent.size() == 2) {

                if (Integer.parseInt(percent.get(0)) > 100) {
                    System.out.println("Error: Program storage exceeds the maximum limit");

                    throw new RuntimeException();
                }
                if (Integer.parseInt(percent.get(1)) > 100) {
                    System.out.println("Error: Dynamic storage exceeds the maximum limit");

                    throw new RuntimeException();
                } else if (Integer.parseInt(percent.get(1)) >= 80) {
                    System.out.println("Warning: Dynamic storage exceeds 80%, which can cause stability issues");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Arduino installation could not be found, unable to determine size");
            e.printStackTrace();
        }

    }

    private static boolean isAllowedType(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."), fileName.length()).equals(".roboduino");
    }

    private static void displayHelp() {
        System.out.println("Usage: java -jar rdbc.jar <input> [output] [--verify]\n");
        System.out.println("<input> - The path to the input Roboduino-file.\n");
        System.out.println("[output] - The path to the output arduino-file.\n" +
                "           Optional. In case of no path provided, Arduino-file with the\n" +
                "           same name and location as the input-file will be generated.\n");
        System.out.println("[--verify] - Use the Arduino storage calculator to perform a size check.\n" +
                "             Optional. If no flag provided, the size check is just skipped. \n");
    }
}
