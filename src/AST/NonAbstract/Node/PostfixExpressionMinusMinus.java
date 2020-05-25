package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class PostfixExpressionMinusMinus extends Statement {
    public Expression e;
    public int line;

    public PostfixExpressionMinusMinus(Expression e, int ln){
        super(ln);
        this.e = e;
        line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }


}
