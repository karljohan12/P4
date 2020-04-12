package AST.NonAbstract.Node;

import AST.Abstract.AbstractMulExpr;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class MultiplicationExpresionDivisionUnaryExpression extends AbstractMulExpr {
    public AbstractMulExpr pme;
    public AbstractunaryExpr aue;

    public MultiplicationExpresionDivisionUnaryExpression(AbstractMulExpr pme, AbstractunaryExpr aue, int ln) {
        super(ln);
        this.pme = pme;
        this.aue = aue;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
