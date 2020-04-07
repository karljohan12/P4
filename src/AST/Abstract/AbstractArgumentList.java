package AST.Abstract;



abstract public class AbstractArgumentList extends ASTNode {
    public AbstractArgumentList(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
