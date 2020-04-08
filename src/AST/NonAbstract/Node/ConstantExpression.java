package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class ConstantExpression extends ASTNode {
    public ExpressionAssignment e;

    public ConstantExpression(ExpressionAssignment e, int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
