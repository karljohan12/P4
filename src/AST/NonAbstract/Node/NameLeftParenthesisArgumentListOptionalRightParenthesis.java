package AST.NonAbstract.Node;

public class NameLeftParenthesisArgumentListOptionalRightParenthesis extends FunctionCall {
    public Name n;
    public AbstractArgumentListOpt aalo;

    public NameLeftParenthesisArgumentListOptionalRightParenthesis(Name n1, AbstractArgumentListOpt aalo1, int ln){
        super(lm);
        n = n1;
        aalo = aalo1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
