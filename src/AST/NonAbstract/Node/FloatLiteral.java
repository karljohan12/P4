package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class FloatLiteral extends AbstractLiteral {
    public Literal l;

    public FloatLiteral(Literal l, int ln) {
        super(ln);
        this.l = l;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
