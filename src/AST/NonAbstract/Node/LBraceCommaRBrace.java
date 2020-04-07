package AST.NonAbstract.Node;

public class LBraceCommaRBrace extends AbstractArrayInit {

    public LBraceCommaRBrace(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
