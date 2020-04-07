package AST.Abstract;

abstract public class AbstractPlusExpr extends ASTNode {
    public AbstractPlusExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
