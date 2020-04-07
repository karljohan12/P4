package AST.NonAbstract.Node;

import AST.Abstract.AbstractBlockStmt;
import AST.Abstract.AbstractStmt;
import AST.Visitor.Visitor;

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
