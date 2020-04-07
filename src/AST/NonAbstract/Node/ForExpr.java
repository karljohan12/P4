package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractForInit;
import AST.Abstract.AbstractStmtExprList;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class ForExpr extends ASTNode {
    public AbstractForInit afi;
    public Expr e;
    public AbstractStmtExprList asel;

    public ForExpr(AbstractForInit afi, Expr e, AbstractStmtExprList asel, int ln) {
        super(ln);
        this.afi = afi;
        this.e = e;
        this.asel = asel;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
