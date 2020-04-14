package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AFunction extends Initial {

 public AFunction(int ln) {
  super(ln);
 }
 public abstract void accept(Visitor v);
}
