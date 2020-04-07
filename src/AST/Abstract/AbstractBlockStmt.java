package AST.Abstract;

abstract public class AbstractBlockStmt extends ASTNode {
    public AbstractBlockStmt(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
