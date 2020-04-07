package AST.NonAbstract.Node;

import AST.Abstract.AbstractFormalParamList;
import AST.Abstract.AbstractFormalParamListOpt;
import AST.Visitor.Visitor;

public class FormalParamList extends AbstractFormalParamListOpt {
    public AbstractFormalParamList afpl;

    public FormalParamList(AbstractFormalParamList afpl, int ln) {
        super(ln);
        this.afpl = afpl;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
