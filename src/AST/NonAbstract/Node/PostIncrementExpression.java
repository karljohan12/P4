package AST.NonAbstract.Node;

public class PostIncrementExpression extends AbstractPostfixExpr {
    public PostincrementExpr pie;

    public PostIncrementExpression(PostincrementExpr pie1, int ln){
        super(ln);
        pie = pie1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
