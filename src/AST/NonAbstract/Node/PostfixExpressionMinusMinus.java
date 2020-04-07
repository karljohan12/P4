package AST.NonAbstract.Node;

public class PostfixExpressionMinusMinus extends PostdecrementExpr {
    public AbstractPostfixExpr apfe;

    public PostfixExpressionMinusMinus(AbstractPostfixExpr apfe1, int ln){
        super(ln);
        apfe = apfe1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
