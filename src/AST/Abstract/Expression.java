package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class Expression extends Statement {
    public Expression(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}


