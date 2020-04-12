package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractunaryExpr;
import AST.Visitor.Visitor;

public class MinusMinusUnaryExpression extends ASTNode {
    public AbstractunaryExpr pe;

    public MinusMinusUnaryExpression(AbstractunaryExpr pe, int ln) {
        super(ln);
        this.pe = pe;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
