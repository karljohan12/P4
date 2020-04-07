package AST.NonAbstract.Node;

public class PlusExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
