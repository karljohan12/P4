package AST.NonAbstract.Node;

import AST.Abstract.AbstractunaryExpr;
import AST.NonAbstract.Nonterminal.PredecrementExpr;
import AST.Visitor.Visitor;

public class PredecrementExpression extends AbstractunaryExpr {
    public PredecrementExpr pde;

    public PredecrementExpression(PredecrementExpr pde1, int ln){
        super(ln);
        pde = pde1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
