package AST.NonAbstract.Node;

public class PostIncrementExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
