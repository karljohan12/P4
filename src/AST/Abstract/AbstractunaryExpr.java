package AST.Abstract;

abstract public class AbstractunaryExpr extends ASTNode {
    public AbstractunaryExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
