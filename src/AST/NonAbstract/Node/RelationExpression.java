package AST.NonAbstract.Node;

import AST.Abstract.AbstractEqualExpr;
import AST.Abstract.AbstractRelationalExpr;
import AST.Visitor.Visitor;

public class RelationExpression extends AbstractEqualExpr {
    public AbstractRelationalExpr are;

    public RelationExpression(AbstractRelationalExpr are, int ln) {
        super(ln);
        this.are = are;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
