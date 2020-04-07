package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStmt;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class IfLparenExprRparen extends ASTNode {
    public Expr e;
    public AbstractStmt as;

    public IfLparenExprRparen(Expr e, AbstractStmt as, int ln) {
        super(ln);
        this.e = e;
        this.as = as;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
