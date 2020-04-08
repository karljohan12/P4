package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractArrayCreationExpr extends ASTNode{
    public AbstractArrayCreationExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
