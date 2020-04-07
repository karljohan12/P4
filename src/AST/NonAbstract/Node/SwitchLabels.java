package AST.NonAbstract.Node;

public class SwitchLabels {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
