package AST.NonAbstract.Node;

public class NoArrayLiteral extends AbstractPrimaryNoNewArray {
    public AbstractLiteral al;

    public NoArrayLiteral(AbstractLiteral al1, int ln){
        super(ln);
        al = al1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
