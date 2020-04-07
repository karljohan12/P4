package AST.Abstract;

abstract public class AbstractSwitchLabels extends ASTNode {
    public AbstractSwitchLabels(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
