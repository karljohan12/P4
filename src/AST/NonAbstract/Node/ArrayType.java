package AST.NonAbstract.Node;

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
