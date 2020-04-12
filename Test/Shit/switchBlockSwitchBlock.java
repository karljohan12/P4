package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlockStmtGroups;
import AST.Visitor.Visitor;

public class switchBlockSwitchBlock extends AbstractSwitchBlockStmtGroups {

    public AbstractSwitchBlockStmtGroups sbsgs;
    public SwitchLabelBlock sbsg;

    public switchBlockSwitchBlock(AbstractSwitchBlockStmtGroups asbsgs, SwitchLabelBlock asbsg, int ln ){
        super(ln);
        sbsgs = asbsgs;
        sbsg = asbsg;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
