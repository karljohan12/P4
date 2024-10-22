package AST.NonAbstract.Node;

import AST.Abstract.AbstractAssignmentOperator;
import AST.Visitor.Visitor;

public class PlusEqual extends AbstractAssignmentOperator {

    public PlusEqual(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
