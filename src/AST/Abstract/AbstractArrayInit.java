package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractArrayInit extends ASTNode{
    public AbstractArrayInit(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
