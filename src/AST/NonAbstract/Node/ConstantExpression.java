package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class ConstantExpression extends ASTNode {
    public Expr e;

    public ConstantExpression(Expr e, int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
