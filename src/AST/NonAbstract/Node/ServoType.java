package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;
//revision
public class ServoType extends AbstractReferenceType {

    public ServoType(int ln){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
