package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalExpr;
import AST.Abstract.AbstractConditionalOrExpr;
import AST.Visitor.Visitor;

public class ConditionalOrExpression extends AbstractConditionalExpr {
    public AbstractConditionalOrExpr acoe;

    public ConditionalOrExpression(AbstractConditionalOrExpr acoe, int ln) {
        super(ln);
        this.acoe = acoe;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
