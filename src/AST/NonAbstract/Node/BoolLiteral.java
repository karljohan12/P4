package AST.NonAbstract.Node;

import AST.Abstract.AbstractLiteral;
import AST.Visitor.Visitor;
//revision
public class BoolLiteral extends AbstractLiteral {
    public boolean b;

    public BoolLiteral(boolean b, int ln) {
        super(ln);
        this.b = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        String s = String.valueOf(b);
        return s;
    }
}
