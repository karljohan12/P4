package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.SwitchGroupList;
import AST.List.SwitchLabelList;
import AST.Visitor.Visitor;

public class SwitchBlockLabels extends Statement {
    public SwitchGroupList s1;
    public SwitchLabelList s2;

    public SwitchBlockLabels(SwitchGroupList s1, SwitchLabelList s2, int ln){
        super(ln);
        this.s1 = s1;
        this.s2 = s2;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
