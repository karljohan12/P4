package AST.NonAbstract.Node;

public class BlockStmtstmt extends AbstractBlockStmts {
    public AbstractBlockStmts abss;
    public AbstractBlockStmt abs;

    public BlockStmtstmt(AbstractBlockStmts abss, AbstractBlockStmt abs, int ln) {
        super(ln);
        this.abss = abss;
        this.abs = abs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
