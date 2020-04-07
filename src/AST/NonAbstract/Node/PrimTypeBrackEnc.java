package AST.NonAbstract.Node;
import AST.Abstract.*;

public class PrimTypeBrackEnc extends AbstractArrayType {
    public AbstractPrimitiveType apt;
    public AbstractBracketEnclosure abe;

    public PrimTypeBrackEnc(AbstractPrimitiveType apt1, AbstractBracketEnclosure abe1, int ln){
        super(ln);
        apt = apt1;
        abe = abe1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
