package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class IfElse extends Statement {
    public Expression e;
    public Statement s1, s2;

    public IfElse(Expression e, Statement s1, Statement s2, int ln){
        super(ln);
        this.e = e;
        this.s1 = s1;
        this.s2 = s2;


    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
