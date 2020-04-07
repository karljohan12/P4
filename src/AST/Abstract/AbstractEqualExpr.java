package AST.Abstract;

abstract public class AbstractEqualExpr extends ASTNode {
    public AbstractEqualExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
