package AST.NonAbstract.Node;
import AST.Abstract.Type;
import Interfaces.IVisitor;

public class StringType extends Type {

    public StringType(int ln ){
        super(ln);
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
