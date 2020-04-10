package AST.NonAbstract.Node;

import AST.Abstract.AbstractLocalVariableDecl;
import AST.Abstract.AbstractType;
import AST.Abstract.AbstractVariableDecls;
import AST.Visitor.Visitor;

public class VariableDecls extends AbstractLocalVariableDecl {
    public AbstractType t;
    public AbstractVariableDecls vds;

    public VariableDecls(AbstractType at, AbstractVariableDecls avds, int ln ){
        super(ln);
        t = at;
        vds=avds;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
