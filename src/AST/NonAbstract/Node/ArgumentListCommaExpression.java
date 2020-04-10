package AST.NonAbstract.Node;
import AST.Visitor.Visitor;

public class ArgumentListCommaExpression extends AbstractArgumentList {
    public AbstractArgumentList al;
    public ExpressionAssignment e;

    public ArgumentListCommaExpression(AbstractArgumentList al1, ExpressionAssignment e1, int ln){
        super(ln);
        al = al1;
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
