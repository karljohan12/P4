package AST.NonAbstract.Node;

public class SwitchLabelsLabel {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
