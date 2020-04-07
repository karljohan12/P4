package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDecl;
import AST.Abstract.AbstractVariableDecls;
import AST.Visitor.Visitor;

public class VariableDecl extends AbstractVariableDecls {
    public AbstractVariableDecl vd;

    public VariableDecl(AbstractVariableDecl avd, int ln){
        super(ln);
        vd = avd;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
