package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class IntType extends Type {
    public IntType(int ln){
        super(ln);

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return "int";
    }

}
