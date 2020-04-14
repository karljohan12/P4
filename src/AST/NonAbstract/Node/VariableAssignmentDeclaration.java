package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import AST.Visitor.Visitor;

public class VariableAssignmentDeclaration extends VariableInitial {
    public Identifier i;
    public VariableInitial a;

    public VariableAssignmentDeclaration(Identifier i, VariableInitial a, int ln){
        super(ln);
        this.i = i;
        this.a = a;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
