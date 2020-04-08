package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.Visitor.Visitor;

public class LeftParenthesisExpressionRightParenthesis extends AbstractPrimaryNoNewArray {
    public ExpressionAssignment e;

    public LeftParenthesisExpressionRightParenthesis(ExpressionAssignment e1, int ln){
        super(ln);
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
