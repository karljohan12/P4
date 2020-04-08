package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

//revision
public class FloatType extends AbstractNumericType {

    public FloatType(int ln){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
