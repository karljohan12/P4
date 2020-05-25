package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class StrLiteral extends Expression {
    public String s;

    public StrLiteral(String s, int ln) {
        super(ln);
        this.s = s;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }
}
