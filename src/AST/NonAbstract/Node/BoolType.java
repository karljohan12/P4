package AST.NonAbstract.Node;

import AST.Abstract.Type;
import Interfaces.IVisitor;

public class BoolType extends Type {
    public BoolType(int ln ){
        super(ln);
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
