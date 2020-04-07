package AST.Abstract;

abstract public class AbstractArrayAccess extends ASTNode {
    public AbstractArrayAccess(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
