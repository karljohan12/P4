package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractAssignmentExpr;
import AST.Abstract.AbstractAssignmentOperator;
import AST.Abstract.AbstractLeftHandSide;
import AST.Visitor.Visitor;

public class AssignmentExpr extends ASTNode {
    public AbstractLeftHandSide alhs;
    public AbstractAssignmentOperator aao;
    public AbstractAssignmentExpr aas;

    public AssignmentExpr(AbstractLeftHandSide alhs, AbstractAssignmentOperator aao, AbstractAssignmentExpr aas, int ln) {
        super(ln);
        this.alhs = alhs;
        this.aao = aao;
        this.aas = aas;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
