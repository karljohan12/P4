package AST.Abstract;

abstract public class AbstractBlockStmts extends ASTNode {
    public AbstractBlockStmts(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
