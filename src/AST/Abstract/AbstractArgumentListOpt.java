package AST.Abstract;

abstract public class AbstractArgumentListOpt extends ASTNode {
    public AbstractArgumentListOpt(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
