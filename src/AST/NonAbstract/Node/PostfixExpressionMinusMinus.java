package AST.NonAbstract.Node;

public class PostfixExpressionMinusMinus {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
