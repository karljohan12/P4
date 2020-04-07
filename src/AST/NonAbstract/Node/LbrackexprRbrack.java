package AST.NonAbstract.Node;

public class LbrackexprRbrack extends BracketEnclosureExpr {
    public expr e;

    public LbrackexprRbrack(expr e1, int ln){
        super(ln);
        e = e1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
