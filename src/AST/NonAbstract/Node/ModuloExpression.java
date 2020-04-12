package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class ModuloExpression extends Expression {
    public Expression e1, e2;

    public ModuloExpression(Expression ae1, Expression ae2, int ln){
        super(ln);
        e1 = ae1;
        e2 = ae2;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}