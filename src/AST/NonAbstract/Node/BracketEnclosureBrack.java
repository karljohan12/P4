package AST.NonAbstract.Node;

import AST.Abstract.AbstractBracketEnclosure;
import AST.Visitor.Visitor;

public class BracketEnclosureBrack extends AbstractBracketEnclosure {
    public AbstractBracketEnclosure abe;

    public BracketEnclosureBrack(AbstractBracketEnclosure abe1, int ln){
        super(ln);
        abe = abe1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
