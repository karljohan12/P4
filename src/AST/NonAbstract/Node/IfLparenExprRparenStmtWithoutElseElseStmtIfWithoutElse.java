package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStmtIfWithoutElse;
import AST.Visitor.Visitor;

public class IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse extends ASTNode {
    public ExpressionAssignment e;
    public AbstractStmtIfWithoutElse asiwe;
    public AbstractStmtIfWithoutElse asiwe1;


    public IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse(ExpressionAssignment e, AbstractStmtIfWithoutElse asiwe, AbstractStmtIfWithoutElse asiwe1, int ln) {
        super(ln);
        this.e = e;
        this.asiwe = asiwe;
        this.asiwe1 = asiwe1;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
