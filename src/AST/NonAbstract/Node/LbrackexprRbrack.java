package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class LbrackexprRbrack extends ASTNode {
    public Expr e;

    public LbrackexprRbrack(Expr e1, int ln){
        super(ln);
        e = e1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
