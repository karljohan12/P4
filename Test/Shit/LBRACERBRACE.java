package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayInit;
import AST.Visitor.Visitor;

public class LBRACERBRACE extends AbstractArrayInit {

    public LBRACERBRACE(int ln) {
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
