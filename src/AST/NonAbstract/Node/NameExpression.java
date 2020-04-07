package AST.NonAbstract.Node;

import AST.Abstract.AbstractPostfixExpr;
import AST.NonAbstract.Nonterminal.Name;
import AST.Visitor.Visitor;

public class NameExpression extends AbstractPostfixExpr {
    public Name n;

    public NameExpression(Name n1, int ln){
        super(ln);
        n = n1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
