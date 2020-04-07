package AST.Abstract;

abstract public class AbstractArrayInit extends ASTNode{
    public AbstractArrayInit(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
