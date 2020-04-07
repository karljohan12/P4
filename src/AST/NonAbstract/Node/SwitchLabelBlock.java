package AST.NonAbstract.Node;

public class SwitchLabelBlock {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
