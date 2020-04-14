package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.SwitchGroupList;
import AST.Visitor.Visitor;
import com.sun.jdi.event.StepEvent;

public class SwitchGroups extends Statement {
    public SwitchGroupList s;

    public SwitchGroups(SwitchGroupList s, int ln){
        super(ln);
        this.s = s;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
