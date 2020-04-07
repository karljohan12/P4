package AST.NonAbstract.Node;

public class BlockStmt extends AbstractBlockStmts {
    public AbstractBlockStmt abs;

    public BlockStmt(AbstractBlockStmt abs, int ln) {
        super(ln);
        this.abs = abs;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
