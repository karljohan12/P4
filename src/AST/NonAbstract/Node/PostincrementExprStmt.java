package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.Visitor.Visitor;

public class PostincrementExprStmt extends AbstractStmtExpr {
    public postfixExpressionPlusPlus pe;

    public PostincrementExprStmt(postfixExpressionPlusPlus pe, int ln) {
        super(ln);
        this.pe = pe;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
