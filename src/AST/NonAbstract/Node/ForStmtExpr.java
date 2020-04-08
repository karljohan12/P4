package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.Visitor.Visitor;

public class ForStmtExpr extends AbstractStmt {
    public ForExpr fs;

    public ForStmtExpr(ForExpr fs, int ln) {
        super(ln);
        this.fs = fs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
