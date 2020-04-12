package AST.NonAbstract.Node;

import AST.Abstract.AbstractAssignmentOperator;
import AST.Visitor.Visitor;

public class Equal extends AbstractAssignmentOperator {

    public Equal(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
