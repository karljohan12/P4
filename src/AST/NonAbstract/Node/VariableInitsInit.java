package AST.NonAbstract.Node;
import AST.Abstract.AbstractVariableInit;
import AST.Abstract.AbstractVariableInits;
import AST.Visitor.Visitor;

public class VariableInitsInit extends AbstractVariableInits {
    public AbstractVariableInits vis;
    public AbstractVariableInit vi;

    VariableInitsInit(AbstractVariableInits avis, AbstractVariableInit avi, int ln){
        super(ln);
        vis=avis;
        vi=avi;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
