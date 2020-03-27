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

       private LexerToken createToken(String val, int start){
            LexerToken tk = new LexerToken(val, start);
                addToken(tk);
              return tk;
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
    "BEGIN"                   { return symbol(sym.BEGIN, createToken(yytext(), yycolumn)); }
    "boolean"                 { return symbol(sym.BOOLEAN, createToken(yytext(), yycolumn)); }
    "break"                   { return symbol(sym.BREAK, createToken(yytext(), yycolumn)); }
    "case"                    { return symbol(sym.CASE, createToken(yytext(), yycolumn)); }
    "const"                   { return symbol(sym.CONST, createToken(yytext(), yycolumn)); }
    "default"                 { return symbol(sym.DEFAULT, createToken(yytext(), yycolumn)); }
    "double"                  { return symbol(sym.DOUBLE, createToken(yytext(), yycolumn)); }
    "else"                    { return symbol(sym.ELSE, createToken(yytext(), yycolumn)); }
    "for"                     { return symbol(sym.FOR, createToken(yytext(), yycolumn)); }
    "else"                    { return symbol(sym.ELSE, createToken(yytext(), yycolumn)); }
    "END"                     { return symbol(sym.END, createToken(yytext(), yycolumn)); }
    "int"                     { return symbol(sym.INT, createToken(yytext(), yycolumn)); }
    "if"                      { return symbol(sym.IF, createToken(yytext(), yycolumn)); }
    "switch"                  { return symbol(sym.SWITCH, createToken(yytext(), yycolumn)); }
    "THEN"                    { return symbol(sym.THEN, createToken(yytext(), yycolumn)); }
    "return"                  { return symbol(sym.RETURN, createToken(yytext(), yycolumn)); }
    "void"                    { return symbol(sym.VOID, createToken(yytext(), yycolumn)); }
    "while"                   { return symbol(sym.WHILE, createToken(yytext(), yycolumn)); }
    "WHEN"                    { return symbol(sym.WHEN, createToken(yytext(), yycolumn)); }
    "Robot"                   { return symbol(sym.ROBOT, createToken(yytext(), yycolumn)); }
    "ServoPosition"           { return symbol(sym.SERVOPOSITION, createToken(yytext(), yycolumn)); }
    "Servo"                   { return symbol(sym.SERVO, createToken(yytext(), yycolumn)); }
    "delay"                   { return symbol(sym.DELAY, createToken(yytext(), yycolumn)); }



    /*boolean literals*/
    "true"                   { return symbol(sym.BOOLEAN_LITERAL, createToken(yytext(), yycolumn), true); }
    "false"                   { return symbol(sym.BOOLEAN_LITERAL, createToken(yytext(), yycolumn), false); }

    /*null literal*/
    "null"                   { return symbol(sym.NULL_LITERAL, createToken(yytext(), yycolumn)); }

    /*separators*/
     "("                            { return symbol(sym.LPAREN, createToken(yytext(), yycolumn)); }
     ")"                            { return symbol(sym.RPAREN, createToken(yytext(), yycolumn)); }
     "{"                            { return symbol(sym.LBRACE, createToken(yytext(), yycolumn)); }
     "}"                            { return symbol(sym.RBRACE, createToken(yytext(), yycolumn)); }
     "["                            { return symbol(sym.LBRACK, createToken(yytext(), yycolumn)); }
     "]"                            { return symbol(sym.RBRACK, createToken(yytext(), yycolumn)); }
     ";"                            { return symbol(sym.SEMICOLON, createToken(yytext(), yycolumn)); }
     ","                            { return symbol(sym.COMMA, createToken(yytext(), yycolumn)); }
     "."                            { return symbol(sym.DOT, createToken(yytext(), yycolumn)); }

     /*operators*/
      "="                            { return symbol(sym.EQ, createToken(yytext(), yycolumn)); }
      ">"                            { return symbol(sym.GT, createToken(yytext(), yycolumn)); }
      "<"                            { return symbol(sym.LT, createToken(yytext(), yycolumn)); }
      "!"                            { return symbol(sym.NOT, createToken(yytext(), yycolumn)); }
      "~"                            { return symbol(sym.COMP, createToken(yytext(), yycolumn)); }
      "?"                            { return symbol(sym.QUESTION, createToken(yytext(), yycolumn)); }
      ":"                            { return symbol(sym.COLON, createToken(yytext(), yycolumn)); }
      "=="                           { return symbol(sym.EQEQ, createToken(yytext(), yycolumn)); }
      "<="                           { return symbol(sym.LTEQ, createToken(yytext(), yycolumn)); }
      ">="                           { return symbol(sym.GTEQ, createToken(yytext(), yycolumn));; }
      "!="                           { return symbol(sym.NOTEQ, createToken(yytext(), yycolumn));; }
      "AND"                           { return symbol(sym.ANDAND, createToken(yytext(), yycolumn)); }
      "OR"                           { return symbol(sym.OROR, createToken(yytext(), yycolumn)); }
      "++"                           { return symbol(sym.PLUSPLUS, createToken(yytext(), yycolumn)); }
      "--"                           { return symbol(sym.MINUSMINUS, createToken(yytext(), yycolumn));}
      "+"                            { return symbol(sym.PLUS, createToken(yytext(), yycolumn)); }
      "-"                            { return symbol(sym.MINUS, createToken(yytext(), yycolumn)); }
      "*"                            { return symbol(sym.MULT, createToken(yytext(), yycolumn)); }
      "/"                            { return symbol(sym.DIV, createToken(yytext(), yycolumn)); }
      "+="                           { return symbol(sym.PLUSEQ, createToken(yytext(), yycolumn)); }
      "-="                           { return symbol(sym.MINUSEQ, createToken(yytext(), yycolumn)); }
      "*="                           { return symbol(sym.MULTEQ, createToken(yytext(), yycolumn)); }
      "/="                           { return symbol(sym.DIVEQ, createToken(yytext(), yycolumn)); }

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



