package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.NonAbstract.Nonterminal.Expr;
import AST.Visitor.Visitor;

public class Expression extends AbstractArgumentList {
    public Expr e;

    public Expression(Expr e1, int ln){
        super(ln);
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
