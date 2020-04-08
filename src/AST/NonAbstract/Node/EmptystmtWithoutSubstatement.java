package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class EmptystmtWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public Semicolon es;

    public EmptystmtWithoutSubstatement(Semicolon es, int ln) {
        super(ln);
        this.es = es;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
