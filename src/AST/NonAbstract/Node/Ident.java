package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDeclId;
import AST.Visitor.Visitor;

public class Ident extends AbstractVariableDeclId {
    public String s;

    public Ident(String as, int ln) {
        super(ln);
        s = as;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }
}
