package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class IdentifierExpression extends Expression {
    public String s;

    public IdentifierExpression(String as, int ln){
        super(ln);
        s = as;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }
}
