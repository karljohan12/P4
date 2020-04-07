package AST.NonAbstract.Node;

import AST.Abstract.AbstractLeftHandSide;
import AST.NonAbstract.Nonterminal.Name;
import AST.Visitor.Visitor;

public class NameAssign extends AbstractLeftHandSide {
    public Name n;

    public NameAssign(Name n, int ln) {
        super(ln);
        this.n = n;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
