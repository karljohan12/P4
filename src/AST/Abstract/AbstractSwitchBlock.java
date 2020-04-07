package AST.Abstract;

abstract public class AbstractSwitchBlock extends ASTNode {
    public AbstractSwitchBlock(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
