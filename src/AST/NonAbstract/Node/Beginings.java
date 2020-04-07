package AST.NonAbstract.Node;

public class Beginings {

    public void accept(Visitor v) {
        v.visit(this);
    }
}
