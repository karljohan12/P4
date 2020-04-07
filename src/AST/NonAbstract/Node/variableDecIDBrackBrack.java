package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableDeclId;
import AST.Visitor.Visitor;

public class variableDecIDBrackBrack extends AbstractVariableDeclId  {
    public AbstractVariableDeclId vdi;

    public variableDecIDBrackBrack(AbstractVariableDeclId avdi, int ln){
        super(ln);
        vdi=avdi;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
