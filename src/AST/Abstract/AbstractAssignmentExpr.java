package AST.Abstract;

abstract public class AbstractAssignmentExpr extends ASTNode {
    public AbstractAssignmentExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
