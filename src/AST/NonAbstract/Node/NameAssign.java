package AST.NonAbstract.Node;

public class NameAssign {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
