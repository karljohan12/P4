package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.NonAbstract.Nonterminal.PredecrementExpr;
import AST.Visitor.Visitor;

public class PreDecrementExprStmt extends AbstractStmtExpr {
    public PredecrementExpr pde;

    public PreDecrementExprStmt(PredecrementExpr apde, int ln){
        super(ln);
        pde = apde;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
