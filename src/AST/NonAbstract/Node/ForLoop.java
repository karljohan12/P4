package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class ForLoop extends Statement {
    public Statement fi;
    public Expression e;
    public Statement sel;

    public ForLoop(Statement fi, Expression e, Statement sel, int ln) {
        super(ln);
        this.fi = fi;
        this.e = e;
        this.sel = sel;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
