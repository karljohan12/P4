package AST.NonAbstract.Node;

public class BracketEnclosureExpression extends AbstractBracketEnclosureExprs {
    public BracketEnclosureExpr bee;

    public BracketEnclosureExpression(BracketEnclosureExpr bee1, int ln){
        super(ln);
        bee = bee1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
