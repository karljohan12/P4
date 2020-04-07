package AST.NonAbstract.Node;

public class IfThenElseStmtExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
