package AST.Abstract;

abstract public class AbstractStart extends ASTNode {
    public AbstractStart(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
