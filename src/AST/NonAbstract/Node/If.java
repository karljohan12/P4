package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class If extends Statement {
    public Expression e;
    public Statement s;

    public If(Expression e, Statement s, int ln){
        super(ln);
        this.e = e;
        this.s = s;


    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
