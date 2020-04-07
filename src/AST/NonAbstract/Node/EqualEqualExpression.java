package AST.NonAbstract.Node;

public class EqualEqualExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
