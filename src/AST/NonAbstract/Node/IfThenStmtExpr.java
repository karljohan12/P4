package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.NonAbstract.Nonterminal.IfThenStmt;
import AST.Visitor.Visitor;

public class IfThenStmtExpr extends AbstractStmt {
    public IfThenStmt its;

    public IfThenStmtExpr(IfThenStmt its, int ln) {
        super(ln);
        this.its = its;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
