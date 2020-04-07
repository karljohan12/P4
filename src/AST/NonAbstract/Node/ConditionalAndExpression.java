package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalAndExpr;
import AST.Abstract.AbstractConditionalOrExpr;
import AST.Visitor.Visitor;

public class ConditionalAndExpression extends AbstractConditionalOrExpr {
    public AbstractConditionalAndExpr acae;

    public ConditionalAndExpression(AbstractConditionalAndExpr acae, int ln) {
        super(ln);
        this.acae = acae;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
