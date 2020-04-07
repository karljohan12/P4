package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchLabel;
import AST.Abstract.AbstractSwitchLabels;
import AST.Visitor.Visitor;

public class SwitchLabelsLabel extends AbstractSwitchLabels {
    public AbstractSwitchLabels sls;
    public AbstractSwitchLabel sl;

    public SwitchLabelsLabel(AbstractSwitchLabels asls, AbstractSwitchLabel asl, int ln){
        super(ln);
        sls = asls;
        sl= asl;


    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
