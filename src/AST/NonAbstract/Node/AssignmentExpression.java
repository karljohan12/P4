package AST.NonAbstract.Node;

public class AssignmentExpression {

    public void accept(Visitor v) {
        v.visit(this);
    }
}
