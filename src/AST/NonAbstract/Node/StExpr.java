package AST.NonAbstract.Node;


import AST.Abstract.AbstractStmtExpr;
import AST.Abstract.AbstractStmtExprList;
import AST.Visitor.Visitor;

public class StExpr extends AbstractStmtExprList {
    public AbstractStmtExpr se;

    public StExpr(AbstractStmtExpr ase, int ln){
        super(ln);
        se = ase;


    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
