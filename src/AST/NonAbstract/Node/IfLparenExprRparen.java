package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStmt;
import AST.Visitor.Visitor;

public class IfLparenExprRparen extends ASTNode {
    public ExpressionAssignment e;
    public AbstractStmt as;

    public IfLparenExprRparen(ExpressionAssignment e, AbstractStmt as, int ln) {
        super(ln);
        this.e = e;
        this.as = as;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
