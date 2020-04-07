package AST.NonAbstract.Node;

public class NotUnaryExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
