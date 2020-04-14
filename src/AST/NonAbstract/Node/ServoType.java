package AST.NonAbstract.Node;

import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class ServoType extends Type {
    public ServoType(int ln){
        super(ln);

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
