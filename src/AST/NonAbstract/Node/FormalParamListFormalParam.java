package AST.NonAbstract.Node;

import AST.Abstract.AbstractFormalParam;
import AST.Abstract.AbstractFormalParamList;
import AST.Visitor.Visitor;

public class FormalParamListFormalParam extends AbstractFormalParamList {
    public AbstractFormalParamList afpl;
    public AbstractFormalParam afp;

    public FormalParamListFormalParam(AbstractFormalParamList afpl, AbstractFormalParam afp, int ln) {
        super(ln);
        this.afpl = afpl;
        this.afp = afp;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
