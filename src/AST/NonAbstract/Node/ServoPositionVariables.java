package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import AST.List.ServoInitializationList;
import AST.Visitor.Visitor;

public class ServoPositionVariables extends VariableInitial {
    public ServoInitializationList vi;

    public ServoPositionVariables(ServoInitializationList vi, int ln){
        super(ln);
        this.vi = vi;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
