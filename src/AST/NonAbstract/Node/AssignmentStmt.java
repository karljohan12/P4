package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;

import AST.Visitor.Visitor;

public class AssignmentStmt extends AbstractStmtExpr {
    public AssignmentExpr aae;

    public AssignmentStmt(AssignmentExpr aae, int ln) {
        super(ln);
        this.aae = aae;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
