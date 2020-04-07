package AST.NonAbstract.Node;

import AST.Abstract.AbstractLiteral;
import AST.Abstract.AbstractServoInits;
import AST.Visitor.Visitor;

public class Literal extends AbstractServoInits {
    public AbstractLiteral li;

    public Literal(AbstractLiteral li, int ln){
        super(ln);
        this.li = li;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
