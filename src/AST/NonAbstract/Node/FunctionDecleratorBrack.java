package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionDeclerator;
import AST.Visitor.Visitor;

public class FunctionDecleratorBrack extends AbstractFunctionDeclerator {
    public AbstractFunctionDeclerator afd;

    public FunctionDecleratorBrack(AbstractFunctionDeclerator afd, int ln) {
        super(ln);
        this.afd = afd;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
