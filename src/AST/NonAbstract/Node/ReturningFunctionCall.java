package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.StatementExpression;
import AST.List.ArgumentList;
import AST.Visitor.Visitor;

public class ReturningFunctionCall extends Expression {

    public Identifier i;
    public ArgumentList Al;

    public ReturningFunctionCall(Identifier i, ArgumentList Al, int ln){
        super(ln);
        this.i = i;
        this.Al = Al;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
