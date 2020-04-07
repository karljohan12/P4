package AST.NonAbstract.Node;

public class ForExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
