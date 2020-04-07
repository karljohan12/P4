package AST.NonAbstract.Node;

public class AssignmentStmt {

    public void accept(Visitor v) {
        v.visit(this);
    }
}
