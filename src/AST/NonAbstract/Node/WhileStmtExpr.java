package AST.NonAbstract.Node;
import AST.NonAbstract.Nonterminal.*;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class WhileStmtExpr extends AbstractStmt {
    public WhileStmt st;

    public WhileStmtExpr(WhileStmt stmt, int ln){
        super(ln);
        st = stmt;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
