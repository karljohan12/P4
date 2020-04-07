package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractLiteral;
import AST.Visitor.Visitor;

public class StrLiteral extends AbstractLiteral {
    public Literal l;

    public StrLiteral(Literal l, int ln) {
        super(ln);
        this.l = l;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
