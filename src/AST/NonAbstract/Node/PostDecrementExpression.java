package AST.NonAbstract.Node;

import AST.Abstract.AbstractPostfixExpr;
import AST.Visitor.Visitor;

public class PostDecrementExpression extends AbstractPostfixExpr {
    public PostfixExpressionMinusMinus pde;

    public PostDecrementExpression(PostfixExpressionMinusMinus pde1, int ln){
        super(ln);
        pde = pde1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
