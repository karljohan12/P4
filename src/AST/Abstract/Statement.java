package AST.Abstract;

import Interfaces.IVisitor;

abstract public class Statement extends VariableInitial {

    public Statement(int ln) {
        super(ln);
    };
    public abstract void accept(IVisitor v);
}

