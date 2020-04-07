package AST.NonAbstract.Node;
import AST.Abstract.*;

public class ArgumentList extends AbstractArgumentListOpt{
    public AbstractArgumentList aal;

    public ArgumentList(AbstractArgumentList aal1, int ln){
        super(ln);
        aal = aal1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
