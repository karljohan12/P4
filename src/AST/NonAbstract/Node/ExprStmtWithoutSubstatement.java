package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class ExprStmtWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public StmtExpr es;

    public ExprStmtWithoutSubstatement(StmtExpr es, int ln) {
        super(ln);
        this.es = es;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
