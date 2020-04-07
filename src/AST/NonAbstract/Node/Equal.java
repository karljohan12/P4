package AST.NonAbstract.Node;

public class Equal {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
