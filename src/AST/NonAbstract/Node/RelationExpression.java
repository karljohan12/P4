package AST.NonAbstract.Node;

public class RelationExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
