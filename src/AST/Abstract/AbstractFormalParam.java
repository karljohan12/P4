package AST.Abstract;

abstract public class AbstractFormalParam extends ASTNode {
    public AbstractFormalParam(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
