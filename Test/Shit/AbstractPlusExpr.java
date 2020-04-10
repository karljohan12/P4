package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractPlusExpr extends ASTNode {
    public AbstractPlusExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
