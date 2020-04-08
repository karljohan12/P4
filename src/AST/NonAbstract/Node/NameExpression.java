package AST.NonAbstract.Node;

import AST.Abstract.AbstractPostfixExpr;
import AST.Visitor.Visitor;

public class NameExpression extends AbstractPostfixExpr {
    public Identifier n;

    public NameExpression(Identifier n1, int ln){
        super(ln);
        n = n1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
