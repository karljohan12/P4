package AST.NonAbstract.Node;

import AST.Abstract.AbstractMulExpr;
import AST.Abstract.AbstractPlusExpr;
import AST.Visitor.Visitor;

public class PlusExpressionMinusMtiplicationExpression extends AbstractPlusExpr {
    public AbstractPlusExpr pe;
    public AbstractMulExpr me;

    public PlusExpressionMinusMtiplicationExpression(AbstractPlusExpr ape, AbstractMulExpr ame, int ln){
        super(ln);
        pe = ape;
        me = ame;

    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
