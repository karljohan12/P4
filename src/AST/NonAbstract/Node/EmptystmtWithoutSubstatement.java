package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.NonAbstract.Nonterminal.EmptyStmt;
import AST.Visitor.Visitor;

public class EmptystmtWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public EmptyStmt es;

    public EmptystmtWithoutSubstatement(EmptyStmt es, int ln) {
        super(ln);
        this.es = es;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
