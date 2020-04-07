package AST.NonAbstract.Node;

public class BlockStmtsOpt extends Block {
    public AbstractBlockStmtsOpt abso;

    public BlockStmtsOpt(AbstractBlockStmtsOpt abso, int ln) {
        super(ln);
        this.abso = abso;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
