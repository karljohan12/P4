package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractBlockStmtsOpt;
import AST.Visitor.Visitor;

public class BlockStmtsOpt extends ASTNode {
    public AbstractBlockStmtsOpt abso;

    public BlockStmtsOpt(AbstractBlockStmtsOpt abso, int ln) {
        super(ln);
        this.abso = abso;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
