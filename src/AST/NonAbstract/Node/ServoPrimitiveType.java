package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimitiveType;
import AST.Visitor.Visitor;
//Revision
public class ServoPrimitiveType extends AbstractPrimitiveType {

    public ServoPrimitiveType(int ln){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
