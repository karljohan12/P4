package AST.NonAbstract.Node;

import AST.Abstract.AbstractAssignmentOperator;
import AST.Visitor.Visitor;

public class MinusEqual extends AbstractAssignmentOperator {

    public MinusEqual(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
