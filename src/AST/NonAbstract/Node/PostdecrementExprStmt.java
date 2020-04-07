package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.NonAbstract.Nonterminal.PostdecrementExpr;
import AST.Visitor.Visitor;

public class PostdecrementExprStmt extends AbstractStmtExpr {
    public PostdecrementExpr pode;

    public PostdecrementExprStmt(PostdecrementExpr apode, int ln){
        super(ln);
        pode = apode;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
