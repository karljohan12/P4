package AST.NonAbstract.Node;

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
