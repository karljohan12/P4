package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Type;
import Interfaces.IVisitor;

public class ConstantFormalParameter extends AFunction {
    public Type t;
    public Identifier i;

    public ConstantFormalParameter(Type t, Identifier i, int ln){
        super(ln);
        this.t = t;
        this.i = i;


    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
