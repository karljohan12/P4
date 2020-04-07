package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtIfWithoutElse;
import AST.NonAbstract.Nonterminal.IfThenElseIfWithoutElse;
import AST.Visitor.Visitor;

public class IfThenElseIfWithoutElseStatement extends AbstractStmtIfWithoutElse {
    public IfThenElseIfWithoutElse itewe;

    public IfThenElseIfWithoutElseStatement(IfThenElseIfWithoutElse itewe, int ln) {
        super(ln);
        this.itewe = itewe;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
