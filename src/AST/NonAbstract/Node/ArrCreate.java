package AST.NonAbstract.Node;

public class ArrCreate extends AbstractPrimary {
    public AbstractArrayCreationExpr aace;

    public ArrCreate(AbstractArrayCreationExpr aace1, int ln){
        super(ln);
        aace = aace1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
