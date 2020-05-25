package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

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

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
