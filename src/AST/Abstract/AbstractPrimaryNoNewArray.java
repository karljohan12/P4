package AST.Abstract;

abstract public class AbstractPrimaryNoNewArray extends ASTNode {
    public AbstractPrimaryNoNewArray(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
