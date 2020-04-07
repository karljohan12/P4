package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionBody;
import AST.NonAbstract.Nonterminal.Block;

public class SemiColonFunction extends AbstractFunctionBlock {
    public Semicolon s;

    public SemiColonFunction(Semicolon s, int ln) {
        super(ln);
        this.s = s;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
