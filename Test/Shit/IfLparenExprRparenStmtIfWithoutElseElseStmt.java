package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStmt;
import AST.Abstract.AbstractStmtIfWithoutElse;
import AST.Visitor.Visitor;

public class IfLparenExprRparenStmtIfWithoutElseElseStmt extends ASTNode {
    public ExpressionAssignment e;
    public AbstractStmtIfWithoutElse asiwe;
    public AbstractStmt as;

    public IfLparenExprRparenStmtIfWithoutElseElseStmt(ExpressionAssignment e, AbstractStmtIfWithoutElse asiwe, AbstractStmt as, int ln) {
        super(ln);
        this.e = e;
        this.asiwe = asiwe;
        this.as = as;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
