package AST.Abstract;

abstract public class AbstractAssignmentOperator extends ASTNode {
    public AbstractAssignmentOperator(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
