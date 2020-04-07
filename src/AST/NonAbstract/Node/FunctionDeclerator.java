package AST.NonAbstract.Node;

import AST.Abstract.AbstractFormalParamListOpt;
import AST.Abstract.AbstractFunctionDeclerator;
import AST.Visitor.Visitor;

public class FunctionDeclerator extends AbstractFunctionDeclerator {
    public AbstractFormalParamListOpt afpo;

    public FunctionDeclerator(AbstractFormalParamListOpt afpo, int ln) {
        super(ln);
        this.afpo = afpo;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
