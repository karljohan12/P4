package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import AST.Visitor.Visitor;

public class IdentifierVariable extends VariableInitial {
    public String s;

    public IdentifierVariable(String s, int ln){
        super(ln);
        this.s = s;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }




}
