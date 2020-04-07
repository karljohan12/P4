package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmt;
import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class StmtWithoutTrailingSubstmt extends AbstractStmt {
    public AbstractStmtWithoutTrailingSubstatement aswts;

    public StmtWithoutTrailingSubstmt(AbstractStmtWithoutTrailingSubstatement aswts, int ln) {
        super(ln);
        this.aswts = aswts;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
