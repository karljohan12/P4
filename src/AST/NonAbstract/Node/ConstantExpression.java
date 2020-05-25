package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class ConstantExpression extends Statement {
    public Expression e;

    public ConstantExpression(Expression e, int ln){
        super(ln);
        this.e = e;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
