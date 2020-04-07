package AST.NonAbstract.Node;

import AST.Abstract.AbstractAssignmentExpr;
import AST.NonAbstract.Nonterminal.Assignment;
import AST.Visitor.Visitor;

public class AssignmentExpression extends AbstractAssignmentExpr {
    public Assignment aae;

    public AssignmentExpression(Assignment aae, int ln) {
        super(ln);
        this.aae = aae;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
