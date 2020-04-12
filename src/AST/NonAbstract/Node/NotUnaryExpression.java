package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class NotUnaryExpression extends Expression {
    public Expression e;

    public NotUnaryExpression(Expression ae, int ln){
        super(ln);
        e = ae;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
