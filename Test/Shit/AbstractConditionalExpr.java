package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractConditionalExpr extends ASTNode {
    public AbstractConditionalExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
