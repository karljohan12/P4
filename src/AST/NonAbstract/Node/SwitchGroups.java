package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlock;
import AST.Abstract.AbstractSwitchBlockStmtGroups;
import AST.Visitor.Visitor;

public class SwitchGroups extends AbstractSwitchBlock {
    public AbstractSwitchBlockStmtGroups sbsgs;

    public SwitchGroups(AbstractSwitchBlockStmtGroups asbsgs, int ln){
        super(ln);
        sbsgs = asbsgs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
