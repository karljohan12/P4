package AST.NonAbstract.Node;

import AST.Abstract.VariableInitial;
import Interfaces.IVisitor;

public class VariableAssignmentDeclaration extends VariableInitial {
    public Identifier i;
    public VariableInitial a;
    public int line;

    public VariableAssignmentDeclaration(Identifier i, VariableInitial a, int ln){
        super(ln);
        this.i = i;
        this.a = a;
        this.line = ln;
    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
