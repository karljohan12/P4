package AST.NonAbstract.Node;

import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class PreIncrementExpression extends AbstractunaryExpr {
    public PlusPlusUnaryExpression pie;

    public PreIncrementExpression(PlusPlusUnaryExpression pie1, int ln){
        super(ln);
        pie = pie1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
