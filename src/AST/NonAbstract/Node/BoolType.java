package AST.NonAbstract.Node;
import AST.Visitor.Visitor;

//revision
public class BoolType extends AbstractPrimitiveType {

    public BoolType(int ln ){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
