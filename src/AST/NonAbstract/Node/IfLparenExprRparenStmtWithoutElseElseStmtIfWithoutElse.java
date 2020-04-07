package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStmtIfWithoutElse;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse extends ASTNode {
    public Expr e;
    public AbstractStmtIfWithoutElse asiwe;
    public AbstractStmtIfWithoutElse asiwe1;


    public IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse(Expr e, AbstractStmtIfWithoutElse asiwe, AbstractStmtIfWithoutElse asiwe1, int ln) {
        super(ln);
        this.e = e;
        this.asiwe = asiwe;
        this.asiwe1 = asiwe1;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
