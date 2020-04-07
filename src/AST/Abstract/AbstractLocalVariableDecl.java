package AST.Abstract;

abstract public class AbstractLocalVariableDecl extends ASTNode {
    public AbstractLocalVariableDecl(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
