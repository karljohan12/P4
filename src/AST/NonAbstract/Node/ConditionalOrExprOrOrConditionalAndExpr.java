package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalAndExpr;
import AST.Abstract.AbstractConditionalOrExpr;
import AST.Visitor.Visitor;

public class ConditionalOrExprOrOrConditionalAndExpr extends AbstractConditionalOrExpr {
    public AbstractConditionalOrExpr acoe;
    public AbstractConditionalAndExpr acae;

    public ConditionalOrExprOrOrConditionalAndExpr(AbstractConditionalOrExpr acoe, AbstractConditionalAndExpr acae, int ln) {
        super(ln);
        this.acoe = acoe;
        this.acae = acae;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
