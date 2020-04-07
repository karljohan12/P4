package AST.Abstract;

abstract public class AbstractNumericType extends ASTNode {
    public AbstractNumericType(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
