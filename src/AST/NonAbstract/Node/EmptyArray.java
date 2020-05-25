package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import Interfaces.IVisitor;

public class EmptyArray extends VariableInitial {

    public EmptyArray(int ln) {
        super(ln);
    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
