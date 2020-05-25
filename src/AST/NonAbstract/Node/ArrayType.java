package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class ArrayType extends Type {
    public Type t;

    public ArrayType(Type t, int ln){
        super(ln);
        this.t = t;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
