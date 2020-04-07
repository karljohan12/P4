package AST.NonAbstract.Node;
import AST.Abstract.*;

public class Expression extends AbstractArgumentList {
    public expr e;

    public Expression(expr e1, int ln){
        super(ln);
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
