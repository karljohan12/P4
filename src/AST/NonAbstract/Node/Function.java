package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import Interfaces.IVisitor;

public class Function extends AFunction {
    public AFunction a1, a2;
    public int line;

    public Function(AFunction a1, AFunction a2, int ln){
        super(ln);
        this.a1 = a1;
        this.a2 = a2;
        line = ln;

    }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
