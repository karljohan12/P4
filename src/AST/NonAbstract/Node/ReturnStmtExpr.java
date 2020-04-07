package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class ReturnStmtExpr extends ASTNode {
    public Expr e;

    public ReturnStmtExpr(Expr e ,int ln) {
        super(ln);
        this.e = e;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
