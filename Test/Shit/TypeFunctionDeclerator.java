package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionDeclerator;
import AST.Abstract.AbstractFunctionHeader;
import AST.Abstract.AbstractType;
import AST.Visitor.Visitor;

public class TypeFunctionDeclerator extends AbstractFunctionHeader {
    public AbstractType t;
    public AbstractFunctionDeclerator fd;

    public TypeFunctionDeclerator(AbstractType at, AbstractFunctionDeclerator afd, int ln){
        super(ln);
        t = at;
        fd = afd;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
