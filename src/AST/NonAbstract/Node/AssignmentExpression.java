package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class AssignmentExpression extends Expression {
    public Expression e1, e2, e3;
    public int line;

    public AssignmentExpression(Expression ae1, Expression ae2, Expression ae3, int ln){
        super(ln);
        e1 = ae1;
        e2 = ae2;
        e3 = ae3;
        line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
