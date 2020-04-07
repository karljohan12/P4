package AST.NonAbstract.Node;

import AST.Abstract.AbstractBracketEnclosure;
import AST.Abstract.AbstractBracketEnclosureOpt;
import AST.Visitor.Visitor;

public class BracketEnc extends AbstractBracketEnclosureOpt {
    public AbstractBracketEnclosure abe;

    public BracketEnc(AbstractBracketEnclosure abe1, int ln){
        super(ln);
        abe = abe1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
