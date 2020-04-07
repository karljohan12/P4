package AST.Abstract;

abstract public class AbstractStmtWithoutTrailingSubstatement extends ASTNode {
    public AbstractStmtWithoutTrailingSubstatement(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
