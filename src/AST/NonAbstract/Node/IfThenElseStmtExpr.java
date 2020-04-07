package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.NonAbstract.Nonterminal.IfThenElseStmt;
import AST.Visitor.Visitor;

public class IfThenElseStmtExpr extends AbstractStmt {
    public IfThenElseStmt ilersiwees;

    public IfThenElseStmtExpr(IfThenElseStmt ilersiwees, int ln) {
        super(ln);
        this.ilersiwees = ilersiwees;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
