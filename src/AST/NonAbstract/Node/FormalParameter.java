package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Type;
import Interfaces.IVisitor;

public class FormalParameter extends AFunction {
    public Type t;
    public Identifier i;
    public int line;

    public FormalParameter(Type t, Identifier i, int ln){
        super(ln);
        this.t = t;
        this.i = i;
        this.line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
