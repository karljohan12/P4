package AST.NonAbstract.Node;

public class FunctionDeclerator {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
