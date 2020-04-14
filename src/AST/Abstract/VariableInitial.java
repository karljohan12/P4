package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class VariableInitial extends BlockStatement {

    public VariableInitial(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
