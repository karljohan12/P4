package AST.NonAbstract.Node;

import AST.Abstract.AbstractMulExpr;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class UnaryExpression extends AbstractMulExpr {
    public AbstractunaryExpr ue;

    public UnaryExpression(AbstractunaryExpr aue, int ln){
        super(ln);
        ue=aue;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
