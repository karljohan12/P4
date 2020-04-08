package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.Visitor.Visitor;

public class FunctionCallStatement extends AbstractStmtExpr {
    public NameLeftParenthesisArgumentListOptionalRightParenthesis fc;

    public FunctionCallStatement(NameLeftParenthesisArgumentListOptionalRightParenthesis fc, int ln) {
        super(ln);
        this.fc = fc;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
