package AST.NonAbstract.Node;

public class ConditionalAndExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
