package AST.NonAbstract.Node;

import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class UnaryExpressionstmt extends AbstractunaryExpr {
    public AbstractunaryExpr ue;

    public UnaryExpressionstmt(AbstractunaryExpr aue, int ln){
        super(ln);
        ue=aue;

    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
