package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class ArrayAccessIndex extends Expression {
    public Identifier i;
    public Expression e;

    public ArrayAccessIndex(Identifier i, Expression e, int ln){
        super(ln);
        this.i = i;
        this.e = e;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
