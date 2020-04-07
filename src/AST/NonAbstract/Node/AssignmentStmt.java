package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.NonAbstract.Nonterminal.Assignment;
import AST.Visitor.Visitor;

public class AssignmentStmt extends AbstractStmtExpr {
    public Assignment aae;

    public AssignmentStmt(Assignment aae, int ln) {
        super(ln);
        this.aae = aae;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
