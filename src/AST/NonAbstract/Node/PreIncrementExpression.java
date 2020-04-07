package AST.NonAbstract.Node;

import AST.Abstract.AbstractunaryExpr;
import AST.NonAbstract.Nonterminal.preincrementExpr;
import AST.Visitor.Visitor;

public class PreIncrementExpression extends AbstractunaryExpr {
    public preincrementExpr pie;

    public PreIncrementExpression(preincrementExpr pie1, int ln){
        super(ln);
        pie = pie1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
