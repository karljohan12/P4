package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlockStmtGroups;

import AST.Visitor.Visitor;

public class SwitchBlockGroup extends AbstractSwitchBlockStmtGroups {
    public SwitchLabelBlock sbsg;

    public SwitchBlockGroup(SwitchLabelBlock asbsg, int ln){
        super(ln);
        sbsg = asbsg;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
