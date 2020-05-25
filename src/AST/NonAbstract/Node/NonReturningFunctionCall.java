package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.ArgumentList;
import Interfaces.IVisitor;

public class NonReturningFunctionCall extends Statement {
    public Identifier i;
    public ArgumentList al;
    public int line;

    public NonReturningFunctionCall(Identifier i, ArgumentList al, int ln){
        super(ln);
        this.i = i;
        this.al = al;
        line = ln;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
