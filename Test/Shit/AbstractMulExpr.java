package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractMulExpr extends ASTNode {
    public AbstractMulExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
