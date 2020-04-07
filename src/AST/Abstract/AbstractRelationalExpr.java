package AST.Abstract;

abstract public class AbstractRelationalExpr extends ASTNode {
    public AbstractRelationalExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
