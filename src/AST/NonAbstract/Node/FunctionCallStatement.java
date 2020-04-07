package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtExpr;
import AST.NonAbstract.Nonterminal.FunctionCall;
import AST.Visitor.Visitor;

public class FunctionCallStatement extends AbstractStmtExpr {
    public FunctionCall fc;

    public FunctionCallStatement(FunctionCall fc, int ln) {
        super(ln);
        this.fc = fc;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
