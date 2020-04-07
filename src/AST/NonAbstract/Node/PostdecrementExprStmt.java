package AST.NonAbstract.Node;

public class PostdecrementExprStmt {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
