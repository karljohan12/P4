package AST.NonAbstract.Node;

import AST.Abstract.AbstractAssignmentExpr;
import AST.Abstract.AbstractConditionalExpr;
import AST.Visitor.Visitor;

public class ConditionalExpression extends AbstractAssignmentExpr {
    public AbstractConditionalExpr ace;

    public ConditionalExpression(AbstractConditionalExpr ace, int ln) {
        super(ln);
        this.ace = ace;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
