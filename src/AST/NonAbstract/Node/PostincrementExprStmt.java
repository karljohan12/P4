package AST.NonAbstract.Node;

public class PostincrementExprStmt {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
