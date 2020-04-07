package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.NonAbstract.Nonterminal.BreakStmt;
import AST.Visitor.Visitor;

public class BreakStatementWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public BreakStmt bs;

    public BreakStatementWithoutSubstatement(BreakStmt bs, int ln) {
        super(ln);
        this.bs = bs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
