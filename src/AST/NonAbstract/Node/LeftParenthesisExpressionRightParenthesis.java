package AST.NonAbstract.Node;

public class LeftParenthesisExpressionRightParenthesis extends AbstractPrimaryNoNewArray {
    public expr e;

    public LeftParenthesisExpressionRightParenthesis(expr e1, int ln){
        super(ln);
        e = e1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
