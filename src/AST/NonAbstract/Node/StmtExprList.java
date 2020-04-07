package AST.NonAbstract.Node;

import AST.Abstract.AbstractForInit;
import AST.Abstract.AbstractStmtExprList;
import AST.Visitor.Visitor;

public class StmtExprList extends AbstractForInit {
    public AbstractStmtExprList sel;

    public StmtExprList(AbstractStmtExprList asel, int ln){
        super(ln);
        sel = asel;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
