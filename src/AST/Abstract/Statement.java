package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class Statement extends VariableInitial {

    public Statement(int ln) {
        super(ln);
    };
    public abstract void accept(Visitor v);
}
