package AST.NonAbstract.Node;

import AST.Abstract.BlockStatement;
import AST.List.BlockStatementList;
import Interfaces.IVisitor;

public class Block extends BlockStatement {
    public BlockStatementList sl;
    public int line;

    public Block(BlockStatementList sl, int ln){
        super(ln);
        this.sl = sl;
        line = ln;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

}
