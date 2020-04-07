package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlockStmtGroups;
import AST.NonAbstract.Nonterminal.SwitchBlockStmtGroup;
import AST.Visitor.Visitor;

public class switchBlockSwitchBlock extends AbstractSwitchBlockStmtGroups {

    public AbstractSwitchBlockStmtGroups sbsgs;
    public SwitchBlockStmtGroup sbsg;

    public switchBlockSwitchBlock(AbstractSwitchBlockStmtGroups asbsgs, SwitchBlockStmtGroup asbsg, int ln ){
        super(ln);
        sbsgs = asbsgs;
        sbsg = asbsg;


    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
