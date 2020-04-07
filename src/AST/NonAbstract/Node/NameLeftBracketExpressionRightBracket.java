package AST.NonAbstract.Node;

import AST.Abstract.AbstractArrayAccess;
import AST.NonAbstract.Nonterminal.Expr;
import AST.NonAbstract.Nonterminal.Name;
import AST.Visitor.Visitor;

public class NameLeftBracketExpressionRightBracket extends AbstractArrayAccess {
    public Name n;
    public Expr e;

    public NameLeftBracketExpressionRightBracket(Name n1, Expr e1, int ln){
        super(ln);
        n = n1;
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
