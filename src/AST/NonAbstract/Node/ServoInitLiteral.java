package AST.NonAbstract.Node;

import AST.Abstract.AbstractLiteral;
import AST.Abstract.AbstractServoInits;
import AST.Visitor.Visitor;

public class ServoInitLiteral extends AbstractServoInits {
    public AbstractServoInits si;
    public AbstractLiteral l;

    public ServoInitLiteral(AbstractServoInits asi, AbstractLiteral al, int ln){
        super(ln);
        si = asi;
        l = al;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
