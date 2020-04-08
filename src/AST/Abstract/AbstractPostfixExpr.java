package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractPostfixExpr extends ASTNode {
    public AbstractPostfixExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
