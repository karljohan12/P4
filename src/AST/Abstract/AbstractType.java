package AST.Abstract;

abstract public class AbstractType extends ASTNode {
    public AbstractType(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
