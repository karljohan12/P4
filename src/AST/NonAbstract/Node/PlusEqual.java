package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class PlusEqual extends Expression {

    public PlusEqual(int ln){
        super(ln);

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
