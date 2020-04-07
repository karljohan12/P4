package AST.NonAbstract.Node;

public class AssignmentExpr {

    public void accept(Visitor v) {
        v.visit(this);
    }
}
