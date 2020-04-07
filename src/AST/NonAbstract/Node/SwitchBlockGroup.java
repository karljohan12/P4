package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlockStmtGroups;
import AST.NonAbstract.Nonterminal.SwitchBlockStmtGroup;
import AST.Visitor.Visitor;

public class SwitchBlockGroup extends AbstractSwitchBlockStmtGroups {
    public SwitchBlockStmtGroup sbsg;

    public SwitchBlockGroup(SwitchBlockStmtGroup asbsg, int ln){
        super(ln);
        sbsg = asbsg;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
