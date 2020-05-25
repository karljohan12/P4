package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

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
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
