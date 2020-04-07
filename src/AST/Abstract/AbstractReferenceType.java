package AST.Abstract;

abstract public class AbstractReferenceType extends ASTNode {
    public AbstractReferenceType(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
