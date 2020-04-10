package AST.NonAbstract.Node;

import AST.Abstract.AbstractLiteral;
import AST.Visitor.Visitor;
//revision
public class FloatLiteral extends AbstractLiteral {
    public double f;

    public FloatLiteral(double f, int ln) {
        super(ln);
        this.f = f;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        String s = String.valueOf(f);
        return s;
    }
}
