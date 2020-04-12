package AST.NonAbstract.Node;

import AST.Abstract.AbstractMulExpr;
import AST.Abstract.AbstractPlusExpr;
import AST.Visitor.Visitor;

public class PlusExpressionPlusMultiplicationExpression extends AbstractPlusExpr {
    public AbstractPlusExpr ape;
    public AbstractMulExpr ame;

    public PlusExpressionPlusMultiplicationExpression(AbstractPlusExpr ape, AbstractMulExpr ame, int ln) {
        super(ln);
        this.ape = ape;
        this.ame = ame;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
