package AST.NonAbstract.Node;

public class FormalParam {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
