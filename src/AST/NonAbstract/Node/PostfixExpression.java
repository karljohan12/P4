package AST.NonAbstract.Node;

public class PostfixExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
