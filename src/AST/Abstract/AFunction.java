package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AFunction extends ASTNode {

 public AFunction(int ln) {
  super(ln);
 }
 public abstract void accept(Visitor v);
}
