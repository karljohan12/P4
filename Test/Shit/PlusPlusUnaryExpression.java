package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class PlusPlusUnaryExpression  extends ASTNode {
    public AbstractunaryExpr aue;

    public PlusPlusUnaryExpression(AbstractunaryExpr aue, int ln) {
        super(ln);
        this.aue = aue;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
