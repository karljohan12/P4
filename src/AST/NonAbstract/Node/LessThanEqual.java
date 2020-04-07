package AST.NonAbstract.Node;

public class LessThanEqual {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
