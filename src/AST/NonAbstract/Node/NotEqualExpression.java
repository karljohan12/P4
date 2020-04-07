package AST.NonAbstract.Node;

public class NotEqualExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
