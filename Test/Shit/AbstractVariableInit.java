package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractVariableInit extends ASTNode {
    public AbstractVariableInit(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
