package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.SwitchLabelList;
import Interfaces.IVisitor;

public class SwitchLabels extends Statement {
    public SwitchLabelList s;

    public SwitchLabels(SwitchLabelList s, int ln){
        super(ln);
        this.s = s;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
