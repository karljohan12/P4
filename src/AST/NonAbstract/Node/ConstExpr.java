package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchLabel;
import AST.NonAbstract.Nonterminal.ConstantExpr;
import AST.Visitor.Visitor;

public class ConstExpr extends AbstractSwitchLabel {
    public ConstantExpr ce;

    public ConstExpr(ConstantExpr ce, int ln) {
        super(ln);
        this.ce = ce;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
