package AST.NonAbstract.Node;

public class ConditionalExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
