package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class ReferenceType extends AbstractType {
    public AbstractReferenceType art;

    public ReferenceType(AbstractReferenceType art1, int ln){
        super(ln);
        art = art1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
