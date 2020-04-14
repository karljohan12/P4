package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class ConstantFormalParameter extends AFunction {
    public Type t;
    public Identifier i;

    public ConstantFormalParameter(Type t, Identifier i, int ln){
        super(ln);
        this.t = t;
        this.i = i;


    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
