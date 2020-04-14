package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class BoolLiteral extends Expression {
    public boolean i;

    public BoolLiteral(boolean i, int ln) {
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
