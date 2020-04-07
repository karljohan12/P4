package AST.NonAbstract.Node;

public class StmtExprListStmtExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
