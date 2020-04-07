package AST.Abstract;

abstract public class AbstractStmt extends ASTNode {
    public AbstractStmt(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
