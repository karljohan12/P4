package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractSwitchBlock;
import AST.Visitor.Visitor;

public class Switch extends ASTNode {
    public ExpressionAssignment e;
    public AbstractSwitchBlock sb;

    public Switch(ExpressionAssignment ae, AbstractSwitchBlock asb, int ln){
        super(ln);
        e = ae;
        sb = asb;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
