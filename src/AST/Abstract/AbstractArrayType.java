package AST.Abstract;

abstract public class AbstractArrayType extends ASTNode {
    public AbstractArrayType(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
