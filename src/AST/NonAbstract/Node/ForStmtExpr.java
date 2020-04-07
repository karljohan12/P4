package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.NonAbstract.Nonterminal.ForStmt;
import AST.Visitor.Visitor;

public class ForStmtExpr extends AbstractStmt {
    public ForStmt fs;

    public ForStmtExpr(ForStmt fs, int ln) {
        super(ln);
        this.fs = fs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
