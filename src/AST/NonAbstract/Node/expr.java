package AST.NonAbstract.Node;

public class expr {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
