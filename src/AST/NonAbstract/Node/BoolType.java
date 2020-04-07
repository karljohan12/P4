package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

//revision
public class BoolType extends AbstractPrimitiveType {
    public BoolType bt;

    public BoolType(BoolType bt1, int ln ){
        super(ln);
        bt = bt1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
