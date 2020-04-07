package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class BoolLiteral extends AbstractLiteral {
    public Literal l;

    public BoolLiteral(Literal l, int ln) {
        super(ln);
        this.l = l;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
