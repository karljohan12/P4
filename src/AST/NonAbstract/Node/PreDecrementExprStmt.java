package AST.NonAbstract.Node;

public class PreDecrementExprStmt {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
