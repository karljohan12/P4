package AST.NonAbstract.Node;

import AST.Abstract.AbstractBracketEnclosureExprs;
import AST.Visitor.Visitor;

public class BracketEnclosureExpression extends AbstractBracketEnclosureExprs {
    public LbrackexprRbrack bee;

    public BracketEnclosureExpression(LbrackexprRbrack bee1, int ln){
        super(ln);
        bee = bee1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
