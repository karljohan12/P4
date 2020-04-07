package AST.Abstract;

abstract public class AbstractPrimitiveType extends ASTNode {
    public AbstractPrimitiveType(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
