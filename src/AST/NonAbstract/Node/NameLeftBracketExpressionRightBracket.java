package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayAccess;
import AST.Visitor.Visitor;

public class NameLeftBracketExpressionRightBracket extends AbstractArrayAccess {
    public Identifier n;
    public ExpressionAssignment e;

    public NameLeftBracketExpressionRightBracket(Identifier n1, ExpressionAssignment e1, int ln){
        super(ln);
        n = n1;
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
