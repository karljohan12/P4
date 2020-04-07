package AST.NonAbstract.Node;
import AST.Abstract.*;

public class PrimitiveType extends AbstractType {
    public AbstractPrimitiveType apt;

    public PrimitiveType(AbstractPrimitiveType apt1, int ln){
        super(ln);
        apt = apt1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
