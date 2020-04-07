package AST.Abstract;

abstract public class AbstractPrimary extends ASTNode {
    public AbstractPrimary(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
