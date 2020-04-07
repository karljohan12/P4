package AST.Abstract;

abstract public class AbstractFormalParamListOpt extends ASTNode {
    public AbstractFormalParamListOpt(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
