package AST.NonAbstract.Node;

import AST.Abstract.AbstractFormalParam;
import AST.Abstract.AbstractType;
import AST.Abstract.AbstractVariableDecl;
import AST.Abstract.AbstractVariableDeclId;
import AST.Visitor.Visitor;

public class TypeVariableDelcId extends AbstractFormalParam {
    public AbstractType t;
    public AbstractVariableDeclId vdi;

    public TypeVariableDelcId(AbstractType at, AbstractVariableDeclId avdi, int ln){
        super(ln);
        t = at;
        vdi = avdi;


    }





    public void accept(Visitor v) {
        v.visit(this);
    }
}
