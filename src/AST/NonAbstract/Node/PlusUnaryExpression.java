package AST.NonAbstract.Node;

import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class PlusUnaryExpression extends AbstractunaryExpr {
    public AbstractunaryExpr aue;

    public PlusUnaryExpression(AbstractunaryExpr aue1, int ln){
        super(ln);
        aue = aue1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
