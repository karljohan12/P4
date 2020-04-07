package AST.NonAbstract.Node;

public class GreaterThan {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
