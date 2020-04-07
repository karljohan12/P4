package AST.NonAbstract.Node;

public class Semicolon {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
