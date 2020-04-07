package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimitiveType;
import AST.Visitor.Visitor;
//Revision
public class ServoPrimitiveType extends AbstractPrimitiveType {
    public ServoPrimitiveType spt;

    public ServoPrimitiveType(ServoPrimitiveType spt1, int ln){
        super(ln);
        spt = spt1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
