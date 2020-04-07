package AST.NonAbstract.Node;

public class PlusUnaryExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
