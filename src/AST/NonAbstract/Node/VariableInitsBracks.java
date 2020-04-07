package AST.NonAbstract.Node;
import AST.Abstract.AbstractArrayInit;
import AST.Abstract.AbstractVariableInits;
import AST.Visitor.Visitor;

public class VariableInitsBracks extends AbstractArrayInit {

    public AbstractVariableInits vi;

    public VariableInitsBracks(AbstractVariableInits avi, int ln){
        super(ln);
        vi=avi;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
