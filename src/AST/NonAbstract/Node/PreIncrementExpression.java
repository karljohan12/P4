package AST.NonAbstract.Node;

public class PreIncrementExpression extends AbstractunaryExpr {
    public PreincrementExpr pie;

    public PreIncrementExpression(PreincrementExpr pie1, int ln){
        super(ln);
        pie = pie1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
