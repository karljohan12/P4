package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDecl;
import AST.Abstract.AbstractVariableDeclId;
import AST.Abstract.AbstractVariableInit;
import AST.Visitor.Visitor;

public class VariableDeclIdVariableInit extends AbstractVariableDecl {
    public AbstractVariableDeclId vdi;
    public AbstractVariableInit vi;

    public VariableDeclIdVariableInit(AbstractVariableDeclId avdi, AbstractVariableInit avi, int ln ){
        super(ln);
        vdi=avdi;
        vi=avi;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
