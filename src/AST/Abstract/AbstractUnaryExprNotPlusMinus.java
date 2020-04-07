package AST.Abstract;

abstract public class AbstractUnaryExprNotPlusMinus extends ASTNode {
    public AbstractUnaryExprNotPlusMinus(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
