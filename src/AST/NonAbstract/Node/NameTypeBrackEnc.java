package AST.NonAbstract.Node;
import AST.Visitor.Visitor;

public class NameTypeBrackEnc extends AbstractArrayType {
    public Identifier n;
    public AbstractBracketEnclosure abe;

    public NameTypeBrackEnc(Identifier n1, AbstractBracketEnclosure abe1, int ln){
        super(ln);
        n = n1;
        abe = abe1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
