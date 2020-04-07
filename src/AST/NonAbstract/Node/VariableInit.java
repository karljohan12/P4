package AST.NonAbstract.Node;
import AST.Abstract.AbstractVariableInit;
import AST.Abstract.AbstractVariableInits;
import AST.Visitor.Visitor;

public class VariableInit extends AbstractVariableInits {
    public AbstractVariableInit vi;

    public VariableInit(AbstractVariableInit avi, int ln){
        super(ln);
        vi = avi;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
