package AST.NonAbstract.Node;

import AST.Abstract.BlockStatement;
import AST.List.BlockStatementList;
import AST.Visitor.Visitor;

public class Block extends BlockStatement {
    public BlockStatementList sl;

    public Block(BlockStatementList sl, int ln){
        super(ln);
        this.sl = sl;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
