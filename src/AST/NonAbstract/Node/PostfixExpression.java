package AST.NonAbstract.Node;

import AST.Abstract.AbstractPostfixExpr;
import AST.Abstract.AbstractUnaryExprNotPlusMinus;
import AST.Visitor.Visitor;

public class PostfixExpression extends AbstractUnaryExprNotPlusMinus {
    public AbstractPostfixExpr ape;

    public PostfixExpression(AbstractPostfixExpr ape, int ln) {
        super(ln);
        this.ape = ape;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
