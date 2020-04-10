package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractunaryExpr extends ASTNode {
    public AbstractunaryExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
