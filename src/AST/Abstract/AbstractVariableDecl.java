package AST.Abstract;

abstract public class AbstractVariableDecl extends ASTNode {
    public AbstractVariableDecl(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
