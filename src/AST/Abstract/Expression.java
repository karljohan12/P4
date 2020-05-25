package AST.Abstract;

import Interfaces.IVisitor;

abstract public class Expression extends Statement {
    public Expression(int ln) {
        super(ln);
    }
    public abstract void accept(IVisitor v);
}


