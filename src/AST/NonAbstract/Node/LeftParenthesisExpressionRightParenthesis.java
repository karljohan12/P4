package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class LeftParenthesisExpressionRightParenthesis extends AbstractPrimaryNoNewArray {
    public Expr e;

    public LeftParenthesisExpressionRightParenthesis(Expr e1, int ln){
        super(ln);
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
