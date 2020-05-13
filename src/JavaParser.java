/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2018  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import AST.NonAbstract.Node.Program;
import AST.Visitor.ASTvisitor;
import AST.Visitor.CodeGeneratorVisitor;
import Scanner.*;
import Parser.*;
import SymbolTable.SymbolTable;
import java_cup.runtime.Symbol;


/**
 * Simple test driver for the java parser. Just runs it on some input files, gives no useful output.
 */
public class JavaParser {

  public static void main(String argv[]) {
    argv = new String[]{"Test/parsertest.txt"};



    for (int i = 0; i < argv.length; i++) {
      try {
        System.out.println("Scanning...");
        Scanner s = new Scanner(new UnicodeEscapes(new FileReader(argv[i])));
        System.out.println("Parsing [" + argv[i] + "]");
        parser p = new parser(s);
        Symbol root = p.parse();
        Program program = (Program)root.value;
        System.out.println("Typechecking...");
        program.accept(new ASTvisitor());
        System.out.println("Generating code...");
        CodeGeneratorVisitor cgv = new CodeGeneratorVisitor();
        program.accept(cgv);

        FileWriter fileWriter = new FileWriter("program.ino");
        System.out.println("Writing to file...");
        fileWriter.write(cgv.code.toString());
        fileWriter.close();
        if(System.getProperty("os.name").startsWith("Windows")) {
          System.out.println("Verifying storage...");
          verify();
        }

        System.out.println("Compilation succeeded");
      } catch (Exception e) {
        e.printStackTrace(System.err);
        System.exit(1);
      }
    }
  }
  public static void verify() throws RuntimeException, IOException, InterruptedException {
    try {

      String value = WindowsReqistry.readRegistry("HKLM\\SOFTWARE\\Classes\\Arduino file\\shell\\open\\command", "");


      String[] pathArray = value.split("\"");
      int indexOfExe = pathArray[1].indexOf("arduino.exe");
      String path = pathArray[1].substring(0, indexOfExe);
      path = path + "arduino_debug";

      //ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Arduino\\arduino_debug", "--verify", "program.ino");
      ProcessBuilder process = new ProcessBuilder(path, "--verify", "program.ino");
      process.redirectOutput(new File("OutputExe.txt"));
      process.redirectError(new File("ErrorOutputExe.txt"));
      process.redirectInput(new File("InputExe.txt"));
      Process e = process.start();
      e.waitFor();
      String storage = Files.readString(Paths.get("OutputExe.txt"));
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
          PrintWriter pw = new PrintWriter("program.ino");
          pw.close();
          throw new RuntimeException();
        }
        if (Integer.parseInt(percent.get(1)) > 100) {
          System.out.println("Error: Dynamic storage exceeds the maximum limit");
          PrintWriter pw = new PrintWriter("program.ino");
          pw.close();
          throw new RuntimeException();
        } else if (Integer.parseInt(percent.get(1)) >= 80) {
          System.out.println("Warning: Dynamic storage exceeds 80 %, which can cause stability issues");
        }
      }
    }
    catch (NullPointerException e){
      System.out.println("Arduino installation could not be found, unable to determine size");
    }

  }
}
