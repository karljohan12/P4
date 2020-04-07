package AST.NonAbstract.Node;

import AST.Abstract.AbstractMulExpr;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class MultiplicationExpressionModuloUnaryExpression extends AbstractMulExpr {
    public AbstractMulExpr ame;
    public AbstractunaryExpr aue;

    public MultiplicationExpressionModuloUnaryExpression(AbstractMulExpr ame, AbstractunaryExpr aue, int ln) {
        super(ln);
        this.ame = ame;
        this.aue = aue;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
