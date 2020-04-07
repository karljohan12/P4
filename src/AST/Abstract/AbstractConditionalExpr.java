package AST.Abstract;

abstract public class AbstractConditionalExpr extends ASTNode {
    public AbstractConditionalExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
