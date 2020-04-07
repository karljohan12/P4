package AST.NonAbstract.Node;

public class stmt extends AbstractBlockStmt {
    public AbstractStmt as;

    public stmt(AbstractStmt as, int ln) {
        super(ln);
        this.as = as;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
