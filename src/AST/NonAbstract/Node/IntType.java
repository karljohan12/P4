package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class IntType extends AbstractNumericType {
    public IntType it;

    public IntType(IntType it1, int ln){
        super(ln);
        it = it1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
