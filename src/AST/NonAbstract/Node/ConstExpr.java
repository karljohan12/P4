package AST.NonAbstract.Node;

public class ConstExpr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
