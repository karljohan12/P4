package AST.NonAbstract.Node;

public class Switch {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
