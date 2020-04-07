package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

//revision
public class FloatType extends AbstractNumericType {
    public FLoatType ft;

    public FloatType(FloatType ft1, int ln){
        super(ln);
        ft = ft1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
