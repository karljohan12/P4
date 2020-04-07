package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDecl;
import AST.Abstract.AbstractVariableDeclId;
import AST.Visitor.Visitor;

public class VariableDeclId extends AbstractVariableDecl {
    public AbstractVariableDeclId vdi;

    public VariableDeclId(AbstractVariableDeclId avdi, int ln){
        super(ln);
        vdi=avdi;


    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
