package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractAssignmentExpr;
import AST.Visitor.Visitor;

public class ExpressionAssignment extends ASTNode {
    public AbstractAssignmentExpr aae;

    public ExpressionAssignment(AbstractAssignmentExpr aae, int ln) {
        super(ln);
        this.aae = aae;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
