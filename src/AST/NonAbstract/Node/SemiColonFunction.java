package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionBody;
import AST.NonAbstract.Nonterminal.Block;
import AST.Visitor.Visitor;

public class SemiColonFunction extends AbstractFunctionBody {
    public Semicolon s;

    public SemiColonFunction(Semicolon s, int ln) {
        super(ln);
        this.s = s;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
