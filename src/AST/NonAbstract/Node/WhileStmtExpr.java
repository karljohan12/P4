package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class WhileStmtExpr extends AbstractStmt {
    public WhileExpr st;

    public WhileStmtExpr(WhileExpr stmt, int ln){
        super(ln);
        st = stmt;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
