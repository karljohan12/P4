package AST.NonAbstract.Node;

public class Primary {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
