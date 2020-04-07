package AST.Abstract;

abstract public class AbstractFunctionHeader extends ASTNode {
    public AbstractFunctionHeader(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
