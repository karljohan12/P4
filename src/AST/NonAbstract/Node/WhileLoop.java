package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class WhileLoop extends Statement {
    public Expression e;

    public WhileLoop(Expression ae, int ln) {
        super(ln);
        this.e = ae;
    }



    public void accept(IVisitor v) {
        v.visit(this);
    }

}
