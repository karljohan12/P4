package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayInit;
import AST.Visitor.Visitor;

public class LBraceCommaRBrace extends AbstractArrayInit {

    public LBraceCommaRBrace(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
