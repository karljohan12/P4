package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class FloatType extends Type {
    public FloatType(int ln){
        super(ln);
    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
