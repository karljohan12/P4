package AST.Abstract;

abstract public class AbstractArrayCreationExpr extends ASTNode{
    public AbstractArrayCreationExpr(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
