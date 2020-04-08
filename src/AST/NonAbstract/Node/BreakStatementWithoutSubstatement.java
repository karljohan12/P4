package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class BreakStatementWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public BreakStmtExpr bs;

    public BreakStatementWithoutSubstatement(BreakStmtExpr bs, int ln) {
        super(ln);
        this.bs = bs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
