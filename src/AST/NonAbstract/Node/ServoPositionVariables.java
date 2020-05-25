package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import AST.List.ServoInitializationList;
import Interfaces.IVisitor;

public class ServoPositionVariables extends VariableInitial {
    public ServoInitializationList vi;

    public ServoPositionVariables(ServoInitializationList vi, int ln){
        super(ln);
        this.vi = vi;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
