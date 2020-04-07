package AST.NonAbstract.Node;

public class DEF {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
