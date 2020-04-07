package AST.NonAbstract.Node;

public class BlockStmts extends AbstractBlockStmtOpt {
    public AbstractBlockStmts abs;

    public BlockStmts(AbstractBlockStmts abs, int ln) {
        super(ln);
        this.abs = abs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
