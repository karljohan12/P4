package AST.NonAbstract.Node;

public class postfixExpressionPlusPlus {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
