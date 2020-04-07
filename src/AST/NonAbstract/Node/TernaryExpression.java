package AST.NonAbstract.Node;

import AST.Abstract.AbstractConditionalExpr;
import AST.Abstract.AbstractConditionalOrExpr;
import AST.Visitor.Visitor;
import java_cup.runtime.XMLElement;

public class TernaryExpression extends AbstractConditionalExpr {
    public AbstractConditionalOrExpr coe;
    public AST.NonAbstract.Nonterminal.Expr e;

    public TernaryExpression(AbstractConditionalOrExpr acoe, AST.NonAbstract.Nonterminal.Expr ae, int ln ){
        super(ln);
        coe = acoe;
        e = ae;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
