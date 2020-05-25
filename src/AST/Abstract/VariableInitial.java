package AST.Abstract;

import Interfaces.IVisitor;

abstract public class VariableInitial extends BlockStatement {

    public VariableInitial(int ln) {
        super(ln);
    }
    public abstract void accept(IVisitor v);
}
