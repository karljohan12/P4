package AST.Abstract;

abstract public class AbstractStmtIfWithoutElse extends ASTNode {
    public AbstractStmtIfWithoutElse(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
