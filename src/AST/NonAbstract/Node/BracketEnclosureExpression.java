package AST.NonAbstract.Node;

import AST.Abstract.AbstractBracketEnclosureExprs;
import AST.NonAbstract.Nonterminal.BracketEnclosureExpr;
import AST.Visitor.Visitor;

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
