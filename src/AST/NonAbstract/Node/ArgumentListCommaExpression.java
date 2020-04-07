package AST.NonAbstract.Node;
import AST.Abstract.*;

public class ArgumentListCommaExpression extends AbstractArgumentList {
    public AbstractArgumentList al;
    public expr e;

    public ArgumentListCommaExpression(AbstractArgumentList al1, expr e1, int ln){
        super(ln);
        al = al1;
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
