package AST.NonAbstract.Node;

public class ForStmtExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
