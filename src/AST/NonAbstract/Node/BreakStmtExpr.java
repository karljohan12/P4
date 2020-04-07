package AST.NonAbstract.Node;

public class BreakStmtExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
