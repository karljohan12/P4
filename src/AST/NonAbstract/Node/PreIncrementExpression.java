package AST.NonAbstract.Node;

public class PreIncrementExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
