package AST.NonAbstract.Node;

import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class IntType extends Type {
    public IntType(int ln){
        super(ln);


    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
