package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class IntegerLiteral extends Expression {
    public int i;

    public IntegerLiteral(int i, int ln) {
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
