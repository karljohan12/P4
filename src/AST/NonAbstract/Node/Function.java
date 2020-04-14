package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Visitor.Visitor;

public class Function extends AFunction {
    public AFunction a1, a2;

    public Function(AFunction a1, AFunction a2, int ln){
        super(ln);
        this.a1 = a1;
        this.a2 = a2;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
