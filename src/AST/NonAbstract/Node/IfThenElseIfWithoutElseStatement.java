package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtIfWithoutElse;
import AST.Visitor.Visitor;

public class IfThenElseIfWithoutElseStatement extends AbstractStmtIfWithoutElse {
    public IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse itewe;

    public IfThenElseIfWithoutElseStatement(IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse itewe, int ln) {
        super(ln);
        this.itewe = itewe;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
