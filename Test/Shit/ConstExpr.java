package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchLabel;
import AST.Visitor.Visitor;

public class ConstExpr extends AbstractSwitchLabel {
    public ConstantExpression ce;

    public ConstExpr(ConstantExpression ce, int ln) {
        super(ln);
        this.ce = ce;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
