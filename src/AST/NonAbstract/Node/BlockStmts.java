package AST.NonAbstract.Node;

import AST.Abstract.AbstractBlockStmts;
import AST.Abstract.AbstractBlockStmtsOpt;
import AST.Visitor.Visitor;

public class BlockStmts extends AbstractBlockStmtsOpt {
    public AbstractBlockStmts abs;

    public BlockStmts(AbstractBlockStmts abs, int ln) {
        super(ln);
        this.abs = abs;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
