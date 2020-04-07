package AST.NonAbstract.Node;

public class GreaterThanEqual {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
