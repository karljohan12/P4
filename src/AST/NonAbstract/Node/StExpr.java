package AST.NonAbstract.Node;

public class StExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
