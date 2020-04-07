package AST.NonAbstract.Nonterminal;
import AST.Abstract.ASTNode;
import AST.NonAbstract.Node.stmt;
import AST.NonAbstract.Nonterminal.*;

public class IfThenStmt extends ASTNode {
    public Expr e;
    public stmt s;

    public IfThenStmt(Expr e, stmt s, int ln) {
        super(ln);
        this.e = e;
        this.s = s;
    }
}
