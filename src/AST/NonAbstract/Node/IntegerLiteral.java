package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class IntegerLiteral extends Expression {
    public int i;

    public IntegerLiteral(int i, int ln) {
        super(ln);
        this.i = i;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        String s = String.valueOf(i);
        return s;
    }
}
