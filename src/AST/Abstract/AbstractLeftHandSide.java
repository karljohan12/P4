package AST.Abstract;

abstract public class AbstractLeftHandSide extends ASTNode {
    public AbstractLeftHandSide(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
