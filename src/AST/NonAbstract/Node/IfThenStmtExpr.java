package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.Visitor.Visitor;

public class IfThenStmtExpr extends AbstractStmt {
    public IfLparenExprRparen its;

    public IfThenStmtExpr(IfLparenExprRparen its, int ln) {
        super(ln);
        this.its = its;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
