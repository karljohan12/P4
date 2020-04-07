package AST.NonAbstract.Node;

public class LessThan {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
