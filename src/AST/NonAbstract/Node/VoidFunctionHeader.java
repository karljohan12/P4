package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import Interfaces.IVisitor;

public class VoidFunctionHeader extends AFunction {
    public AFunction a;
    public int line;

    public VoidFunctionHeader(AFunction a, int ln){
        super(ln);
        this.a = a;
        this.line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
