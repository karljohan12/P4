package AST.NonAbstract.Node;

import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class ServoPrimitiveType extends Type {

    public ServoPrimitiveType(int ln){
        super(ln);


    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
