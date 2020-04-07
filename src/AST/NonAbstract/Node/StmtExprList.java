package AST.NonAbstract.Node;

public class StmtExprList {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
