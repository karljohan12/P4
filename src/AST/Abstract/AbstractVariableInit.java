package AST.Abstract;

abstract public class AbstractVariableInit extends ASTNode {
    public AbstractVariableInit(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
