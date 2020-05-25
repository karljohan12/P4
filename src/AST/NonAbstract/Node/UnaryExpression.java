package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class UnaryExpression extends Expression {
    public Expression e;

    public UnaryExpression(Expression ae, int ln){
        super(ln);
        e = ae;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
