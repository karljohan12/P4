package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class NumericType extends AbstractPrimitiveType {
    public AbstractNumericType ant;

    public NumericType(AbstractNumericType ant1, int ln){
        super(ln);
        ant = ant1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
