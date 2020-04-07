package AST.Abstract;

abstract public class AbstractMulExpr extends ASTNode {
    public AbstractMulExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
