package AST.NonAbstract.Node;

import AST.Abstract.AbstractBracketEnclosure;
import AST.Visitor.Visitor;

public class LbrackRbrack extends AbstractBracketEnclosure {

    public LbrackRbrack(int ln){
        super(ln);
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
