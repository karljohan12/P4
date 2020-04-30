package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class Switch extends Statement {
    public Expression e;
    public Statement s;
    public int line;

    public Switch(Expression e, Statement s, int ln){
        super(ln);
        this.e = e;
        this.s = s;
        line = ln;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
