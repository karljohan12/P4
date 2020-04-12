package AST.NonAbstract.Node;

import AST.Abstract.AbstractLiteral;
import AST.Visitor.Visitor;

public class StrLiteral extends AbstractLiteral {
    public String s;

    public StrLiteral(String s, int ln) {
        super(ln);
        this.s = s;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
