package AST.NonAbstract.Node;

public class ComparableUnaryExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
