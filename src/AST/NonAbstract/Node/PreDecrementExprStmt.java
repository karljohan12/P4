package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.Visitor.Visitor;

public class PreDecrementExprStmt extends AbstractStmtExpr {
    public MinusMinusUnaryExpression pde;

    public PreDecrementExprStmt(MinusMinusUnaryExpression apde, int ln){
        super(ln);
        pde = apde;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
