package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractPostfixExpr;
import AST.Visitor.Visitor;

public class postfixExpressionPlusPlus extends ASTNode {
    public AbstractPostfixExpr apfe;

    public postfixExpressionPlusPlus(AbstractPostfixExpr apfe1, int ln){
        super(ln);
apfe = apfe1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
