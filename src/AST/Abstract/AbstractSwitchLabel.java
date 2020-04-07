package AST.Abstract;

abstract public class AbstractSwitchLabel extends ASTNode {
    public AbstractSwitchLabel(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
