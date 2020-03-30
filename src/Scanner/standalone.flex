/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2018  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


/**
   This is a small example of a standalone text substitution scanner 
   It reads a IDENTIFIER after the keyword IDENTIFIER and substitutes all occurences
   of "hello" with "hello <IDENTIFIER>!". There is a sample input file
   "sample.inp" provided in this directory 
*/

package de.jflex.example.standalone;
import java_cup.runtime.*;
%%

%public
%class Scanner
%implements sym

%unicode

%line
%column

%cup
%cupdebug



%{

    StringBuilder string = new StringBuilder();

    private Symbol symbol(int type) {
        return new JavaSymbol(type, yyline+1, yycolumn+1);
      }
      private Symbol symbol(int type, Object value) {
        return new JavaSymbol(type, yyline+1, yycolumn+1, value);
      }
%}

/*whitespace*/
WhiteSpace = [\r|\n|\r\n] | [ \t\f]

/*comments*/
Comment = {TraditionalComment}|{SingleLineComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
SingleLineComment = "//" [^\r\n]*[\r|\n|\r\n]?

/*Identifiers*/
Identifier = [A-z][A-z|0-9]*

/*integers*/
Integer = 0 |[1-9][0-9]*

OctIntegerLiteral = 0+ [1-3]? {OctDigit} {1,15}
OctLongLiteral    = 0+ 1? {OctDigit} {1,21} [lL]
OctDigit          = [0-7]

/*double*/
Double = (([0-9]+\.[0-9]+)|([0-9]+))
/*radian*/

/*character & string*/
StringCharacter = [^\r\n\"\\]

%state STRING

%%


<YYINITIAL> {

    /*keywords*/
    "BEGIN"                   { return symbol(BEGIN); }
    "boolean"                   { return symbol(BOOLEAN); }
    "break"                   { return symbol(BREAK); }
    "case"                   { return symbol(CASE); }
    "const"                   { return symbol(CONST); }
    "default"                   { return symbol(DEFAULT); }
    "double"                   { return symbol(DOUBLE); }
    "else"                   { return symbol(ELSE); }
    "for"                   { return symbol(FOR); }
    "else"                   { return symbol(ELSE); }
    "END"                   { return symbol(END); }
    "int"                   { return symbol(INT); }
    "if"                   { return symbol(IF); }
    "switch"                   { return symbol(SWITCH); }
    "THEN"                   { return symbol(THEN); }
    "return"                   { return symbol(RETURN); }
    "void"                   { return symbol(VOID); }
    "while"                   { return symbol(WHILE); }
    "WHEN"                   { return symbol(WHEN); }
    "Robot"                   { return symbol(ROBOT); }
    "ServoPosition"                   { return symbol(SERVOPOSITION); }
    "Servo"                   { return symbol(SERVO); }
    "delay"                   { return symbol(DELAY); }



    /*boolean literals*/
    "true"                   { return symbol(BOOLEAN_LITERAL, true); }
    "false"                   { return symbol(BOOLEAN_LITERAL, false); }

    /*null literal*/
    "null"                   { return symbol(NULL_LITERAL); }

    /*separators*/
     "("                            { return symbol(LPAREN); }
     ")"                            { return symbol(RPAREN); }
     "{"                            { return symbol(LBRACE); }
     "}"                            { return symbol(RBRACE); }
     "["                            { return symbol(LBRACK); }
     "]"                            { return symbol(RBRACK); }
     ";"                            { return symbol(SEMICOLON); }
     ","                            { return symbol(COMMA); }
     "."                            { return symbol(DOT); }

     /*operators*/
      "="                            { return symbol(EQ); }
      ">"                            { return symbol(GT); }
      "<"                            { return symbol(LT); }
      "!"                            { return symbol(NOT); }
      "~"                            { return symbol(COMP); }
      "?"                            { return symbol(QUESTION); }
      ":"                            { return symbol(COLON); }
      "=="                           { return symbol(EQEQ); }
      "<="                           { return symbol(LTEQ); }
      ">="                           { return symbol(GTEQ); }
      "!="                           { return symbol(NOTEQ); }
      "AND"                           { return symbol(ANDAND); }
      "OR"                           { return symbol(OROR); }
      "++"                           { return symbol(PLUSPLUS); }
      "--"                           { return symbol(MINUSMINUS); }
      "+"                            { return symbol(PLUS); }
      "-"                            { return symbol(MINUS); }
      "*"                            { return symbol(MULT); }
      "/"                            { return symbol(DIV); }
      "+="                           { return symbol(PLUSEQ); }
      "-="                           { return symbol(MINUSEQ); }
      "*="                           { return symbol(MULTEQ); }
      "/="                           { return symbol(DIVEQ); }

      /* string literal */
      \"                             { yybegin(STRING); string.setLength(0); }

      /*numeric literals*/
      {Integer}            { return symbol(INTEGER_LITERAL, Integer.valueOf(yytext())); }
      {Double}                { return symbol(FLOATING_POINT_LITERAL, new Double(yytext())); }

      /* comments */
      {Comment}                      { /* ignore */ }

      /* whitespace */
      {WhiteSpace}                   { /* ignore */ }

      /* identifiers */
      {Identifier}                   { return symbol(IDENTIFIER, yytext()); }
}

<STRING> {
\"                             { yybegin(YYINITIAL); return symbol(STRING_LITERAL, string.toString()); }

  {StringCharacter}+             { string.append( yytext() ); }

  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\[0-3]?{OctDigit}?{OctDigit}  { char val = (char) Integer.parseInt(yytext().substring(1),8);
                                       string.append( val ); }

}



