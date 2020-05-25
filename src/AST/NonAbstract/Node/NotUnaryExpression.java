package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class NotUnaryExpression extends Expression {
    public Expression e;

    public NotUnaryExpression(Expression ae, int ln){
        super(ln);
        e = ae;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
