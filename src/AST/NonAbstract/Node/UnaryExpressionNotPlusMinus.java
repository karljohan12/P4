package AST.NonAbstract.Node;

import AST.Abstract.AbstractUnaryExprNotPlusMinus;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class UnaryExpressionNotPlusMinus extends AbstractunaryExpr {
    public AbstractUnaryExprNotPlusMinus uenpm;

    public UnaryExpressionNotPlusMinus(AbstractUnaryExprNotPlusMinus auenpm, int ln){
        super(ln);
        uenpm=auenpm;


    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
