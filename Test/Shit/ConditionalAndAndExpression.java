package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalAndExpr;
import AST.Abstract.AbstractEqualExpr;
import AST.Visitor.Visitor;

public class ConditionalAndAndExpression extends AbstractConditionalAndExpr {
    public AbstractConditionalAndExpr acae;
    public AbstractEqualExpr aee;

    public ConditionalAndAndExpression(AbstractConditionalAndExpr acae, AbstractEqualExpr aee, int ln) {
        super(ln);
        this.acae = acae;
        this.aee = aee;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
