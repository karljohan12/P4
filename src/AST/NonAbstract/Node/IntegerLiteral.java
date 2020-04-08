package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractLiteral;
import AST.Visitor.Visitor;
//revision
public class IntegerLiteral extends AbstractLiteral {
    public int i;

    public IntegerLiteral(int i, int ln) {
        super(ln);
        this.i = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        String s = String.valueOf(i);
        return s;
    }
}
