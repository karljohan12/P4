package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractEqualExpr extends ASTNode {
    public AbstractEqualExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
