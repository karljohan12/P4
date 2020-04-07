package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.NonAbstract.Nonterminal.Name;
import AST.Visitor.Visitor;


public class NameType extends AbstractReferenceType {
    public Name n;

    public NameType(Name n1, int ln){
        super(ln);
        n = n1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
