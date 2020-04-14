package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class WhileLoop extends Statement {
    public Expression e;

    public WhileLoop(Expression ae, int ln) {
        super(ln);
        this.e = ae;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }

}
