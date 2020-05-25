package AST.NonAbstract.Node;


import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class MinusEqual extends Expression {
    public MinusEqual(int ln) {
        super(ln);
    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
