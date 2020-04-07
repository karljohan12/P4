package AST.Abstract;

abstract public class AbstractVariableInits extends ASTNode {
    public AbstractVariableInits(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
