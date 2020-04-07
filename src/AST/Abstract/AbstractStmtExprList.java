package AST.Abstract;

abstract public class AbstractStmtExprList extends ASTNode {
    public AbstractStmtExprList(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
