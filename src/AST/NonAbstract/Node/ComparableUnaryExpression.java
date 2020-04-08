package AST.NonAbstract.Node;

import AST.Abstract.AbstractUnaryExprNotPlusMinus;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class ComparableUnaryExpression extends AbstractUnaryExprNotPlusMinus {
    public AbstractunaryExpr aue;

    public ComparableUnaryExpression(AbstractunaryExpr aue, int ln) {
        super(ln);
        this.aue = aue;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
