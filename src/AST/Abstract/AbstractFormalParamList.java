package AST.Abstract;

abstract public class AbstractFormalParamList extends ASTNode {
    public AbstractFormalParamList(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
