package AST.NonAbstract.Node;

public class SwitchLabel {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
