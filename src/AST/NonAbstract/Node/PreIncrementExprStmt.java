package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.Visitor.Visitor;

public class PreIncrementExprStmt extends AbstractStmtExpr {
    public PreIncrementExprStmt pie;

    public PreIncrementExprStmt(PreIncrementExprStmt apie, int ln){
        super(ln);
        pie = apie;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
