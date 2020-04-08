package AST.NonAbstract.Node;

import AST.Abstract.AbstractLeftHandSide;
import AST.Visitor.Visitor;

public class NameAssign extends AbstractLeftHandSide {
    public Identifier n;

    public NameAssign(Identifier n, int ln) {
        super(ln);
        this.n = n;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
