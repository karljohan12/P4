package AST.Abstract;

abstract public class AbstractFunctionBody extends ASTNode {
    public AbstractFunctionBody(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
