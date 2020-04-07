package AST.Abstract;

abstract public class AbstractConditionalOrExpr extends ASTNode {
    public AbstractConditionalOrExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
