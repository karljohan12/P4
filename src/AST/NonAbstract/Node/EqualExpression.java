package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalAndExpr;
import AST.Abstract.AbstractEqualExpr;
import AST.Visitor.Visitor;

public class EqualExpression extends AbstractConditionalAndExpr {
    public AbstractEqualExpr aee;

    public EqualExpression(AbstractEqualExpr aee, int ln) {
        super(ln);
        this.aee = aee;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
