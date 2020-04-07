package AST.NonAbstract.Node;

import AST.Abstract.AbstractFormalParam;
import AST.Abstract.AbstractFormalParamList;
import AST.Visitor.Visitor;

public class FormalParam extends AbstractFormalParamList {
    public AbstractFormalParam afp;

    public FormalParam(AbstractFormalParam afp, int ln) {
        super(ln);
        this.afp = afp;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
