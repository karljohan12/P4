package AST.NonAbstract.Node;

public class ReturnStmtExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
