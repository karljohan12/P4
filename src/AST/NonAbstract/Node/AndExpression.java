package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class AndExpression extends Expression {
    public Expression e1, e2;

    public AndExpression(Expression ae1, Expression ae2, int ln){
        super(ln);
        e1 = ae1;
        e2 = ae2;



    }
    public void accept(IVisitor v) {
        v.visit(this);
    }


}
