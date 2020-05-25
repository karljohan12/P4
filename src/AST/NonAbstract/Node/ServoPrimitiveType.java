package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class ServoPrimitiveType extends Type {

    public ServoPrimitiveType(int ln){
        super(ln);


    }
    public void accept(IVisitor v) {
        v.visit(this);
    }


}
