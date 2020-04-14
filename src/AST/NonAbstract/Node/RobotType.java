package AST.NonAbstract.Node;

import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class RobotType extends Type {
    public RobotType(int ln){
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
