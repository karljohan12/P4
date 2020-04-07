package AST.NonAbstract.Node;

public class Primary extends AbstractPostfixExpr {
    public AbstractPrimary ap;

    public Primary(AbstractPrimary ap1, int ln){
        super(ln);
        ap = ap1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
