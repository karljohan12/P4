/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2018  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

import java.io.*;

import AST.NonAbstract.Node.Program;
import AST.Visitor.ASTvisitor;
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
        System.out.println("Parsing [" + argv[i] + "]");
        Scanner s = new Scanner(new UnicodeEscapes(new FileReader(argv[i])));
        parser p = new parser(s);
        Symbol root = p.parse();
        Program program = (Program)root.value;
        program.accept(new ASTvisitor());


        System.out.println("No errors.");
      } catch (Exception e) {
        e.printStackTrace(System.err);
        System.exit(1);
      }
    }
  }
}
