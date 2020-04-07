package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlock;
import AST.Abstract.AbstractSwitchLabels;
import AST.Visitor.Visitor;

public class SwitchLabels extends AbstractSwitchBlock {
    public AbstractSwitchLabels sls;

    public SwitchLabels(AbstractSwitchLabels asls, int ln){
        super(ln);
        sls = asls;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
