package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractStmtExprList extends ASTNode {
    public AbstractStmtExprList(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
