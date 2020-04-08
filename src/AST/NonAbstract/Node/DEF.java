package AST.NonAbstract.Node;

import AST.Abstract.AbstractSwitchLabel;
import AST.Visitor.Visitor;

public class DEF extends AbstractSwitchLabel {

    public DEF(int ln) {
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
