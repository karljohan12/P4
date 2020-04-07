package AST.NonAbstract.Node;

public class ConditionalOrExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
