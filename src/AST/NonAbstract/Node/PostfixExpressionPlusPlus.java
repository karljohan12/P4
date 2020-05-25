package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class PostfixExpressionPlusPlus extends Statement {
    public Expression e;
    public int line;

    public PostfixExpressionPlusPlus(Expression e, int ln){
        super(ln);
        this.e = e;
        line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }


}
