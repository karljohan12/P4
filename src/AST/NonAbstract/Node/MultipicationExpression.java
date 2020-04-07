package AST.NonAbstract.Node;

public class MultipicationExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
