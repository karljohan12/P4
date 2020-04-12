package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;

import AST.Visitor.Visitor;

public class ReturnStmtExpr extends ASTNode {
    public ExpressionAssignment e;

    public ReturnStmtExpr(ExpressionAssignment e ,int ln) {
        super(ln);
        this.e = e;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
