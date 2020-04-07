package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.NonAbstract.Nonterminal.Name;
import AST.Visitor.Visitor;

public class NameTypeBrackEnc extends AbstractArrayType {
    public Name n;
    public AbstractBracketEnclosure abe;

    public NameTypeBrackEnc(Name n1, AbstractBracketEnclosure abe1, int ln){
        super(ln);
        n = n1;
        abe = abe1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
