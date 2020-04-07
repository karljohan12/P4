package AST.NonAbstract.Node;

public class postfixExpressionPlusPlus extends PostincrementExpr {
    public AbstractPostfixExpr apfe;

    public postfixExpressionPlusPlus(AbstractPostfixExpr apfe1, int ln){
        super(ln);
apfe = apfe1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
