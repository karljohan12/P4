package AST.NonAbstract.Node;

public class PrimaryNoNewArrayLeftBracketExpressionRightBracket extends AbstractArrayAccess {
    public AbstractPrimaryNoNewArray apnna;
    public expr e;

    public PrimaryNoNewArrayLeftBracketExpressionRightBracket(AbstractPrimaryNoNewArray apnna1, expr e1, int ln){
        super(ln);
        apnna = apnna1;
        e = e1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
