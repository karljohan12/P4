package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStmtExpr;
import AST.Visitor.Visitor;

public class StmtExpr extends ASTNode {
    public AbstractStmtExpr se;

    public StmtExpr(AbstractStmtExpr ase, int ln){
        super(ln);
        se = ase;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
