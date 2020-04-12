package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayAccess;
import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.Visitor.Visitor;

public class PrimaryNoNewArrayLeftBracketExpressionRightBracket extends AbstractArrayAccess {
    public AbstractPrimaryNoNewArray apnna;
    public ExpressionAssignment e;

    public PrimaryNoNewArrayLeftBracketExpressionRightBracket(AbstractPrimaryNoNewArray apnna1, ExpressionAssignment e1, int ln){
        super(ln);
        apnna = apnna1;
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
