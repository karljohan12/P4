package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalExpr;
import AST.Abstract.AbstractConditionalOrExpr;
import AST.Visitor.Visitor;

public class TernaryExpression extends AbstractConditionalExpr {
    public AbstractConditionalOrExpr coe;
    public ExpressionAssignment e;
    public AbstractConditionalExpr ce;

    public TernaryExpression(AbstractConditionalOrExpr acoe, ExpressionAssignment ae, AbstractConditionalExpr ace, int ln ){
        super(ln);
        coe = acoe;
        e = ae;
        ce = ace;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
