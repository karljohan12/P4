package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.Visitor.Visitor;

public class IfThenElseStmtExpr extends AbstractStmt {
    public IfLparenExprRparenStmtIfWithoutElseElseStmt ilersiwees;

    public IfThenElseStmtExpr(IfLparenExprRparenStmtIfWithoutElseElseStmt ilersiwees, int ln) {
        super(ln);
        this.ilersiwees = ilersiwees;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
