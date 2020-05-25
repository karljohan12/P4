package AST.Abstract;

import Interfaces.IVisitor;

abstract public class AFunction extends Initial {

 public AFunction(int ln) {
  super(ln);
 }
 public abstract void accept(IVisitor v);
}
