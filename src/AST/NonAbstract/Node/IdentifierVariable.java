package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import Interfaces.IVisitor;

public class IdentifierVariable extends VariableInitial {
    public String s;

    public IdentifierVariable(String s, int ln){
        super(ln);
        this.s = s;
    }


    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }




}
