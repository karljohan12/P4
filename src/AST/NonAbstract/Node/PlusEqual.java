package AST.NonAbstract.Node;

public class PlusEqual {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
