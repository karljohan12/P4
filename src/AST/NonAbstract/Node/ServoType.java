package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class ServoType extends Type {
    public ServoType(int ln){
        super(ln);

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
