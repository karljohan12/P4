package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.Abstract.AbstractStmtExpr;
import AST.Abstract.AbstractStmtExprList;
import AST.Visitor.Visitor;

public class StmtExprListStmtExpr extends AbstractStmtExprList {
    public AbstractStmtExprList sel;
    public AbstractStmtExpr se;

    public StmtExprListStmtExpr(AbstractStmtExprList asel, AbstractStmtExpr ase, int ln){
        super(ln);
        sel = asel;
        se =ase;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
