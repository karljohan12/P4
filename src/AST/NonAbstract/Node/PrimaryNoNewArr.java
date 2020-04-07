package AST.NonAbstract.Node;

import AST.Abstract.AbstractPrimary;
import AST.Abstract.AbstractPrimaryNoNewArray;
import AST.Visitor.Visitor;

public class PrimaryNoNewArr extends AbstractPrimary {
    public AbstractPrimaryNoNewArray apnna;

    public PrimaryNoNewArr(AbstractPrimaryNoNewArray apnna1, int ln){
        super(ln);
        apnna = apnna1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
