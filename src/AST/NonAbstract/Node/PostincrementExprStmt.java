package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.NonAbstract.Nonterminal.PostincrementExpr;
import AST.Visitor.Visitor;

public class PostincrementExprStmt extends AbstractStmtExpr {
    public PostincrementExpr pe;

    public PostincrementExprStmt(PostincrementExpr pe, int ln) {
        super(ln);
        this.pe = pe;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
