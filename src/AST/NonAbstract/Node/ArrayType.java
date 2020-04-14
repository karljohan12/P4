package AST.NonAbstract.Node;

import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class ArrayType extends Type {
    public Type t;

    public ArrayType(Type t, int ln){
        super(ln);
        this.t = t;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
