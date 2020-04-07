package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlock;
import AST.Abstract.AbstractSwitchBlockStmtGroups;
import AST.Abstract.AbstractSwitchLabels;
import AST.Visitor.Visitor;

public class SwitchBlockLabels extends AbstractSwitchBlock {
    public AbstractSwitchBlockStmtGroups sbsgs;
    public AbstractSwitchLabels sl;

    public SwitchBlockLabels(AbstractSwitchBlockStmtGroups asbsgs, AbstractSwitchLabels asl, int ln){
        super(ln);
        sbsgs = asbsgs;
        sl = asl;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
