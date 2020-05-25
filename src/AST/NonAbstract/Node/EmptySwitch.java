package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class EmptySwitch extends Statement {

    public EmptySwitch(int ln){
        super(ln);
    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
