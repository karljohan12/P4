package AST.NonAbstract.Node;

public class NameLeftBracketExpressionRightBracket extends AbstractArrayAccess {
    public Name n;
    public expr e;

    public NameLeftBracketExpressionRightBracket(Name n1, expr e1, int ln){
        super(ln);
        n = n1;
        e = e1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
