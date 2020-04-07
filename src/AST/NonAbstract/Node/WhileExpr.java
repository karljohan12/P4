package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class WhileExpr extends ASTNode {
    public expr e;

    public WhileExpr(expr ae, int ln) {
        super(ln);
        e = ae;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
