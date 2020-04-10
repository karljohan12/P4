package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractConditionalAndExpr extends ASTNode {
    public AbstractConditionalAndExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
