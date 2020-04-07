package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchBlock;
import AST.Visitor.Visitor;

public class Beginings extends AbstractSwitchBlock {

    public Beginings(int ln) {
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
