package AST.NonAbstract.Node;

public class PrimitiveTypeBracketEnclosureArrayInit extends AbstractArrayCreationExpr {
    public AbstractPrimitiveType apt;
    public AbstractBracketEnclosure abe;
    public AbstractArrayInit aai;

    public PrimitiveTypeBracketEnclosureArrayInit(AbstractPrimitiveType apt1, AbstractBracketEnclosure abe1, AbstractArrayInit aai1){
        super()
    }




    public void accept(Visitor v) {
        v.visit(this);
    }
}
