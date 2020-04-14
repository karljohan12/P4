package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class EmptySwitch extends Statement {

    public EmptySwitch(int ln){
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
