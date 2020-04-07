package AST.NonAbstract.Node;

public class StmtExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
