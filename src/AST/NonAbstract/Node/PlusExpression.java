package AST.NonAbstract.Node;

import AST.Abstract.AbstractPlusExpr;
import AST.Abstract.AbstractRelationalExpr;
import AST.Visitor.Visitor;

public class PlusExpression extends AbstractRelationalExpr {
    public AbstractPlusExpr ape;

    public PlusExpression(AbstractPlusExpr ape, int ln) {
        super(ln);
        this.ape = ape;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
