package AST.NonAbstract.Node;

public class SwitchBlockGroup {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
