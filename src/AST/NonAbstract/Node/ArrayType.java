package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayType;
import AST.Abstract.AbstractReferenceType;
import AST.Visitor.Visitor;

public class ArrayType extends AbstractReferenceType {
    public AbstractArrayType aat;

    public ArrayType(AbstractArrayType aat1, int ln){
        super(ln);
        aat = aat1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
