package AST.NonAbstract.Node;
import AST.Abstract.*;

public class BoolType extends AbstractPrimitiveType {
    public BoolType bt;

    public BoolType(BoolType bt1, int ){
        super(ln);
        bt = bt1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
