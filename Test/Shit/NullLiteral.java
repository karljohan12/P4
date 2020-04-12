package AST.NonAbstract.Node;

import AST.Abstract.AbstractLiteral;
import AST.Visitor.Visitor;
//revision
public class NullLiteral extends AbstractLiteral {
    public Object o;

    public NullLiteral(Object o, int ln) {
        super(ln);
        this.o = o;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return "NULL";
    }
}
