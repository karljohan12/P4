package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.Abstract.Type;
import AST.List.VariableDeclarationList;
import AST.Visitor.Visitor;

public class ConstantVariableDeclaration extends Statement {
    public Type t;
    public VariableDeclarationList vdl;
    public int line;

    public ConstantVariableDeclaration(Type t, VariableDeclarationList vdl, int ln){
        super(ln);
        this.t = t;
        this.vdl = vdl;
        line = ln;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
