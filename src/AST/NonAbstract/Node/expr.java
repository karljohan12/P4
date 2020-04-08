package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableInit;
import AST.Visitor.Visitor;

public class expr extends AbstractVariableInit {
    public ExpressionAssignment e;

    public expr(ExpressionAssignment e, int ln) {
        super(ln);
        this.e = e;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
