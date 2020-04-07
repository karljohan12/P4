package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDeclId;
import AST.Visitor.Visitor;

public class Ident extends AbstractVariableDeclId {
    public String s;

    public Ident(String s, int ln) {
        super(ln);
        this.s = s;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
