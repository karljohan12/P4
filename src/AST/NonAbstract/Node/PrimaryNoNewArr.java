package AST.NonAbstract.Node;

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
