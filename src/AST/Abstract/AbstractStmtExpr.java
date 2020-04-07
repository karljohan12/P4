package AST.Abstract;

abstract public class AbstractStmtExpr extends ASTNode {
    public AbstractStmtExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
