package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayCreationExpr;
import AST.Abstract.AbstractArrayInit;
import AST.Abstract.AbstractBracketEnclosure;
import AST.Abstract.AbstractPrimitiveType;
import AST.Visitor.Visitor;

public class PrimitiveTypeBracketEnclosureArrayInit extends AbstractArrayCreationExpr {
    public AbstractPrimitiveType apt;
    public AbstractBracketEnclosure abe;
    public AbstractArrayInit aai;

    public PrimitiveTypeBracketEnclosureArrayInit(AbstractPrimitiveType apt1, AbstractBracketEnclosure abe1, AbstractArrayInit aai1, int ln){
        super(ln);
        apt = apt1;
        abe = abe1;
        aai = aai1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
