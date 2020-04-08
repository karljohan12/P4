package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionBody;
import AST.Visitor.Visitor;

public class FunctionBlock extends AbstractFunctionBody {
    public BlockStmtsOpt b;

    public FunctionBlock(BlockStmtsOpt b, int ln) {
        super(ln);
        this.b = b;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
