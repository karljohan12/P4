package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayInit;
import AST.Abstract.AbstractVariableInit;
import AST.Visitor.Visitor;

public class ArrayInit extends AbstractVariableInit {
    public AbstractArrayInit avi;

    public ArrayInit(AbstractArrayInit avi, int ln) {
        super(ln);
        this.avi = avi;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
