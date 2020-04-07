package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class ArgumentListCommaExpression extends AbstractArgumentList {
    public AbstractArgumentList al;
    public Expr e;

    public ArgumentListCommaExpression(AbstractArgumentList al1, Expr e1, int ln){
        super(ln);
        al = al1;
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
