package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractVariableInits extends ASTNode {
    public AbstractVariableInits(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
