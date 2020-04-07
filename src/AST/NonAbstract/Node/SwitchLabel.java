package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchLabel;
import AST.Abstract.AbstractSwitchLabels;
import AST.Visitor.Visitor;

public class SwitchLabel extends AbstractSwitchLabels
{
    public AbstractSwitchLabel sl;

    public SwitchLabel(AbstractSwitchLabel asl, int ln){
        super(ln);
        sl = asl;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
