package AST.NonAbstract.Node;

public class BracketEnclosureExprsExpr extends AbstractBracketEnclosureExprs {
    public AbstractBracketEnclosureExprs abee;
    public BracketEnclosureExpr bee;

    public BracketEnclosureExprsExpr(AbstractBracketEnclosureExprs abee1, BracketEnclosureExpr bee1, int ln){
        super(ln);
        abee = abee1;
        bee = bee1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
