package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractConditionalOrExpr extends ASTNode {
    public AbstractConditionalOrExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
