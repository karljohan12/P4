package AST.NonAbstract.Node;

public class PredecrementExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
