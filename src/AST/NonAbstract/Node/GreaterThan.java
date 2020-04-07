package AST.NonAbstract.Node;

import AST.Abstract.AbstractPlusExpr;
import AST.Abstract.AbstractRelationalExpr;
import AST.Visitor.Visitor;

public class GreaterThan extends AbstractRelationalExpr {
    public AbstractRelationalExpr are;
    public AbstractPlusExpr ape;

    public GreaterThan(AbstractRelationalExpr are, AbstractPlusExpr ape, int ln) {
        super(ln);
        this.are = are;
        this.ape = ape;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
