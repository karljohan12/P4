package AST.NonAbstract.Node;


import AST.Abstract.AbstractArrayAccess;
import AST.Abstract.AbstractLeftHandSide;
import AST.Visitor.Visitor;

public class ArrayAccess extends AbstractLeftHandSide {

    public AbstractArrayAccess aa;

    public ArrayAccess(AbstractArrayAccess aa1, int ln){
        super(ln);
        aa = aa1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
