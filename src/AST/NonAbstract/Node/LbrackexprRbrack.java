package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class LbrackexprRbrack extends ASTNode {
    public ExpressionAssignment e;

    public LbrackexprRbrack(ExpressionAssignment e1, int ln){
        super(ln);
        e = e1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
