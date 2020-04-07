package AST.Abstract;

abstract public class AbstractFunctionDeclerator extends ASTNode {
    public AbstractFunctionDeclerator(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
