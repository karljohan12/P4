package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;


public class NameType extends AbstractReferenceType {
    public Identifier n;

    public NameType(Identifier n1, int ln){
        super(ln);
        n = n1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
