package AST.NonAbstract.Node;

public class StatementBlock {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
