package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

//revision
public class RobotType extends AbstractReferenceType {

    public RobotType(int ln){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
