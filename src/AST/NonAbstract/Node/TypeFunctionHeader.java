package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class TypeFunctionHeader extends AFunction {
    public Type t;
    public AFunction a;

    public TypeFunctionHeader(Type t, AFunction a, int ln){
        super(ln);
        this.t = t;
        this.a = a;


    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
