package AST.Abstract;

abstract public class AbstractPostfixExpr extends ASTNode {
    public AbstractPostfixExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
