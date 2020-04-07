package AST.NonAbstract.Node;

public class ConstantExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
