package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.SwitchGroupList;
import Interfaces.IVisitor;

public class SwitchGroups extends Statement {
    public SwitchGroupList s;

    public SwitchGroups(SwitchGroupList s, int ln){
        super(ln);
        this.s = s;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
