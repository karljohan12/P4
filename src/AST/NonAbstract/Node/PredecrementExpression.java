package AST.NonAbstract.Node;

import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class PredecrementExpression extends AbstractunaryExpr {
    public MinusMinusUnaryExpression pde;

    public PredecrementExpression(MinusMinusUnaryExpression pde1, int ln){
        super(ln);
        pde = pde1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
