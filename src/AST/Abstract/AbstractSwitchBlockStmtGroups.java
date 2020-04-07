package AST.Abstract;

abstract public class AbstractSwitchBlockStmtGroups extends ASTNode {
    public AbstractSwitchBlockStmtGroups(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
