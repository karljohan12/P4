package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.Visitor.Visitor;

public class PostdecrementExprStmt extends AbstractStmtExpr {
    public PostfixExpressionMinusMinus pode;

    public PostdecrementExprStmt(PostfixExpressionMinusMinus apode, int ln){
        super(ln);
        pode = apode;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
