package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class PlusEqual extends Expression {

    public PlusEqual(int ln){
        super(ln);

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
