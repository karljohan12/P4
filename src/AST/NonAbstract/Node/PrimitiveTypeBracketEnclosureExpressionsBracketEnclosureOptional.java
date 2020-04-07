package AST.NonAbstract.Node;

public class PrimitiveTypeBracketEnclosureExpressionsBracketEnclosureOptional extends AbstractArrayCreationExpr {
    public AbstractPrimitiveType apt;
    public AbstractBracketEnclosureExpr abee;
    public AbstractBracketEnclosureOpt abeo;

    public PrimitiveTypeBracketEnclosureExpressionsBracketEnclosureOptional(AbstractPrimitiveType apt1, AbstractBracketEnclosureExpr abee1, AbstractBracketEnclosureOpt abeo1, int ln){
        super(ln);
        apt = apt1;
        abee = abee1;
        abeo = abeo1;
    }




    public void accept(Visitor v) {
        v.visit(this);
    }
}
