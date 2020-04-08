package AST.NonAbstract.Node;

import AST.Abstract.AbstractPostfixExpr;
import AST.Visitor.Visitor;

public class PostIncrementExpression extends AbstractPostfixExpr {
    public postfixExpressionPlusPlus pie;

    public PostIncrementExpression(postfixExpressionPlusPlus pie1, int ln){
        super(ln);
        pie = pie1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
