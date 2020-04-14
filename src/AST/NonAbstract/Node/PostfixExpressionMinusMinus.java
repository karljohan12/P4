package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class PostfixExpressionMinusMinus extends Statement {
    public Expression e;

    public PostfixExpressionMinusMinus(Expression e, int ln){
        super(ln);
        this.e = e;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }


}
