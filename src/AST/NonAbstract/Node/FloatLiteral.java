package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class FloatLiteral extends Expression {
    public double i;

    public FloatLiteral(double i, int ln) {
        super(ln);
        this.i = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        String s = String.valueOf(i);
        return s;
    }
}
