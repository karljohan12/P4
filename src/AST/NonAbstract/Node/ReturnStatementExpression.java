package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class ReturnStatementExpression extends Statement {
    public Expression e;

    public ReturnStatementExpression(Expression e, int ln){
        super(ln);
        this.e = e;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }


}
