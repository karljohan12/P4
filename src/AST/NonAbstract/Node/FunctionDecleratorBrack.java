package AST.NonAbstract.Node;

public class FunctionDecleratorBrack {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
