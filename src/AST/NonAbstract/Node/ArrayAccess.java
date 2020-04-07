package AST.NonAbstract.Node;
import AST.Abstract.*;

public class ArrayAccess extends AbstractLeftHandSide{

    public AbstractArrayAcces aa;

    public ArrayAcces(ArrayAccess aa1, int ln){
        super(ln);
        aa = aa1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
