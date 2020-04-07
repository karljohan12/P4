package AST.NonAbstract.Node;

public class SwitchGroups {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
