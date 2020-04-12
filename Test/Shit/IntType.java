package AST.NonAbstract.Node;
import AST.Visitor.Visitor;
//revision
public class IntType extends AbstractNumericType {

    public IntType(int ln){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
