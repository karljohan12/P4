package AST.NonAbstract.Node;

public class LbrackRbrack extends AbstractBracketEnclosure {

    public LbrackRbrack(int ln){
        super(ln);
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
