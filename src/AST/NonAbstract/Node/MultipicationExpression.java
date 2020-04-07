package AST.NonAbstract.Node;

import AST.Abstract.AbstractMulExpr;
import AST.Abstract.AbstractPlusExpr;
import AST.Visitor.Visitor;

public class MultipicationExpression extends AbstractPlusExpr {
    public AbstractMulExpr ame;

    public MultipicationExpression(AbstractMulExpr ame, int ln) {
        super(ln);
        this.ame = ame;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
