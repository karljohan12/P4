package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDecl;
import AST.Abstract.AbstractVariableDecls;
import AST.Visitor.Visitor;

public class variableDeclsVariableDecl extends AbstractVariableDecls {
    public AbstractVariableDecls vds;
    public AbstractVariableDecl vd;

    public variableDeclsVariableDecl(AbstractVariableDecls avds, AbstractVariableDecl avd, int ln){
        super(ln);
        vds=avds;
        vd=avd;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
