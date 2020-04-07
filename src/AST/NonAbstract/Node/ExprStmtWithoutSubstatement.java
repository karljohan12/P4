package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.NonAbstract.Nonterminal.ExprStmt;
import AST.Visitor.Visitor;

public class ExprStmtWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public ExprStmt es;

    public ExprStmtWithoutSubstatement(ExprStmt es, int ln) {
        super(ln);
        this.es = es;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
