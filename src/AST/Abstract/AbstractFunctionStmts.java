package AST.Abstract;

abstract public class AbstractFunctionStmts extends ASTNode {
    public AbstractFunctionStmts(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
