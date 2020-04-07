package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayAccess;
import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.Visitor.Visitor;

public class ArrayAccessNoNewArray extends AbstractPrimaryNoNewArray {
    public AbstractArrayAccess aa;

    public ArrayAccessNoNewArray(AbstractArrayAccess aa1, int ln){
        super(ln);
        aa = aa1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
