package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Visitor.Visitor;

public class VoidFunctionHeader extends AFunction {
    public AFunction a;

    public VoidFunctionHeader(AFunction a, int ln){
        super(ln);
        this.a = a;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
