package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.List.ArgumentList;
import AST.Visitor.Visitor;

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
    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return i.s;
    }
}
