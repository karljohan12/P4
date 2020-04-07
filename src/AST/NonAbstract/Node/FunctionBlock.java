package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionBody;
import AST.NonAbstract.Nonterminal.Block;
import AST.Visitor.Visitor;

public class FunctionBlock extends AbstractFunctionBody {
    public Block b;

    public FunctionBlock(Block b, int ln) {
        super(ln);
        this.b = b;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
