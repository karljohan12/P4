package AST.NonAbstract.Node;

public class LBRACERBRACE extends AbstractArrayInit {

    public LBRACERBRACE(int ln) {
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
