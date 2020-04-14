package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class StrLiteral extends Expression {
    public String s;

    public StrLiteral(String s, int ln) {
        super(ln);
        this.s = s;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
