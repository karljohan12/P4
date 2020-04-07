package AST.Abstract;

abstract public class AbstractBlockStmtsOpt extends ASTNode {
    public AbstractBlockStmtsOpt(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
