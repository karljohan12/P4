package AST.NonAbstract.Node;

public class PlusPlusUnaryExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
