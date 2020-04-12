package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class ForInitial extends ASTNode {

 public ForInitial(int ln) {
  super(ln);
 }
 public abstract void accept(Visitor v);
}
