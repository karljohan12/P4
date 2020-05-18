package AST.NonAbstract.Node;
import AST.Abstract.Type;
import AST.Visitor.Visitor;

public class StringType extends Type {

    public StringType(int ln ){
        super(ln);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
