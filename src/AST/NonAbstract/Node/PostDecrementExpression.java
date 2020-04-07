package AST.NonAbstract.Node;

public class PostDecrementExpression extends AbstractPostfixExpr {
    public PostdecrementExpr pde;

    public PostDecrementExpression(PostdecrementExpr pde1, int ln){
        super(ln);
        pde = pde1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
