package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.List.ArgumentList;
import Interfaces.IVisitor;

public class ReturningFunctionCall extends Expression {

    public Identifier i;
    public ArgumentList al;
    public int line;

    public ReturningFunctionCall(Identifier i, ArgumentList al, int ln){
        super(ln);
        this.i = i;
        this.al = al;
        line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return i.s;
    }
}
