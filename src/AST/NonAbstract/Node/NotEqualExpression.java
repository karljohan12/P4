package AST.NonAbstract.Node;

import AST.Abstract.AbstractEqualExpr;
import AST.Abstract.AbstractRelationalExpr;
import AST.Visitor.Visitor;

public class NotEqualExpression extends AbstractEqualExpr {
    public AbstractEqualExpr aee;
    public AbstractRelationalExpr are;

    public NotEqualExpression(AbstractEqualExpr aee, AbstractRelationalExpr are, int ln) {
        super(ln);
        this.aee = aee;
        this.are = are;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
