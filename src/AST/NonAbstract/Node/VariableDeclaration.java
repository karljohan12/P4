package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.Abstract.Type;
import AST.List.VariableDeclarationList;
import AST.Visitor.Visitor;

public class VariableDeclaration extends Statement {
    public Type t;
    public VariableDeclarationList vdl;

    public VariableDeclaration(Type t, VariableDeclarationList vdl, int ln){
        super(ln);
        this.t = t;
        this.vdl = vdl;


    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
