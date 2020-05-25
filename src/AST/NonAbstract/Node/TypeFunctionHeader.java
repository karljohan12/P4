package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Type;
import Interfaces.IVisitor;

public class TypeFunctionHeader extends AFunction {
    public Type t;
    public AFunction a;
    public int line;

    public TypeFunctionHeader(Type t, AFunction a, int ln){
        super(ln);
        this.t = t;
        this.a = a;
        this.line = ln;


    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
