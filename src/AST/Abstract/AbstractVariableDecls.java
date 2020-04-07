package AST.Abstract;

abstract public class AbstractVariableDecls extends ASTNode {
    public AbstractVariableDecls(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
