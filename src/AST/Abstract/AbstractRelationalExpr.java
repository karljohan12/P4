package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractRelationalExpr extends ASTNode {
    public AbstractRelationalExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
