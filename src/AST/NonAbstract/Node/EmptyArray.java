package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import AST.Visitor.Visitor;

public class EmptyArray extends VariableInitial {

    public EmptyArray(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
