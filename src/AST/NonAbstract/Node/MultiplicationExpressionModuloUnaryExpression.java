package AST.NonAbstract.Node;

public class MultiplicationExpressionModuloUnaryExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
