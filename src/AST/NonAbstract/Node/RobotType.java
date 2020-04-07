package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

//revision
public class RobotType extends AbstractReferenceType {
    public RobotType rt;

    public RobotType(RobotType rt1, int ln){
        super(ln);
        rt = rt1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
