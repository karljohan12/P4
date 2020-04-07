package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayCreationExpr;
import AST.Abstract.AbstractBracketEnclosureExprs;
import AST.Abstract.AbstractBracketEnclosureOpt;
import AST.Abstract.AbstractPrimitiveType;
import AST.Visitor.Visitor;

public class PrimitiveTypeBracketEnclosureExpressionsBracketEnclosureOptional extends AbstractArrayCreationExpr {
    public AbstractPrimitiveType apt;
    public AbstractBracketEnclosureExprs abee;
    public AbstractBracketEnclosureOpt abeo;

    public PrimitiveTypeBracketEnclosureExpressionsBracketEnclosureOptional(AbstractPrimitiveType apt1, AbstractBracketEnclosureExprs abee1, AbstractBracketEnclosureOpt abeo1, int ln){
        super(ln);
        apt = apt1;
        abee = abee1;
        abeo = abeo1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
