package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableInit;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class expr extends AbstractVariableInit {
    public Expr e;

    public expr(Expr e, int ln) {
        super(ln);
        this.e = e;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
