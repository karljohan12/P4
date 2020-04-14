package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.SwitchLabelList;
import AST.Visitor.Visitor;

public class SwitchLabels extends Statement {
    public SwitchLabelList s;

    public SwitchLabels(SwitchLabelList s, int ln){
        super(ln);
        this.s = s;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
