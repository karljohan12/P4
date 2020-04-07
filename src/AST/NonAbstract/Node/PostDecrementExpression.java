package AST.NonAbstract.Node;

import AST.Abstract.AbstractPostfixExpr;
import AST.NonAbstract.Nonterminal.PostdecrementExpr;
import AST.Visitor.Visitor;

public class PostDecrementExpression extends AbstractPostfixExpr {
    public PostdecrementExpr pde;

    public PostDecrementExpression(PostdecrementExpr pde1, int ln){
        super(ln);
        pde = pde1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
