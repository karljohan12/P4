package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class LessThanEqual extends Expression {
    public Expression e1, e2;
    public int line;

    public LessThanEqual(Expression ae1, Expression ae2, int ln){
        super(ln);
        e1 = ae1;
        e2 = ae2;
        line = ln;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
