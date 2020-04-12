package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class FunctionBody extends ASTNode {

 public FunctionBody(int ln) {
  super(ln);
 }
 public abstract void accept(Visitor v);
}
