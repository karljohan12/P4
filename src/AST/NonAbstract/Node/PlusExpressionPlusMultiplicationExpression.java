package AST.NonAbstract.Node;

public class PlusExpressionPlusMultiplicationExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
