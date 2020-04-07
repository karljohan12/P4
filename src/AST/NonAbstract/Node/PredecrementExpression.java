package AST.NonAbstract.Node;

public class PredecrementExpression extends AbstractUnaryExpr {
    public PredecrementExpr pde;

    public PredecrementExpression(PredecrementExpr pde1, int ln){
        super(ln);
        pde = pde1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
