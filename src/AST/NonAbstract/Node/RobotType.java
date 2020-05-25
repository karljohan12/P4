package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class RobotType extends Type {
    public RobotType(int ln){
        super(ln);
    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
