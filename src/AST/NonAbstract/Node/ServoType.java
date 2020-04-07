package AST.NonAbstract.Node;
import AST.Abstract.*;

public class ServoType extends AbstractReferenceType {
    public ServoType st;

    public ServoType(ServoType st1, int ln){
        super(ln);
        st = st1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
