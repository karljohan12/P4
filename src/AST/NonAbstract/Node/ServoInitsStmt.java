package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractServoInits;
import AST.Visitor.Visitor;

public class ServoInitsStmt extends ASTNode {
    public AbstractServoInits si;

    public ServoInitsStmt(AbstractServoInits asi, int ln){
        super(ln);
        si = asi;


    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
