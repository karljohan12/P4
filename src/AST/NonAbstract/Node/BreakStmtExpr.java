package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class BreakStmtExpr extends ASTNode {

    public BreakStmtExpr(int ln) {
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
