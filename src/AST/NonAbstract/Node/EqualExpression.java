package AST.NonAbstract.Node;

public class EqualExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
