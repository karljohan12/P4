package AST.NonAbstract.Node;

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
