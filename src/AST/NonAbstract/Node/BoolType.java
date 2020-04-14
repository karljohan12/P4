package AST.NonAbstract.Node;

import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class BoolType extends Type {
    public BoolType(int ln ){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
