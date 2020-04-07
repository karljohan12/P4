package AST.NonAbstract.Node;

public class PreIncrementExprStmt {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
