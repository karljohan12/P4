package AST.NonAbstract.Node;

public class PostDecrementExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
