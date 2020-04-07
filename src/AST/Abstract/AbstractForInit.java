package AST.Abstract;

abstract public class AbstractForInit extends ASTNode {
    public AbstractForInit(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
