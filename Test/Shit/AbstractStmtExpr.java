package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractStmtExpr extends ASTNode {
    public AbstractStmtExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
