package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.BlockStatementList;
import AST.Visitor.Visitor;

public class ABlockStatement extends Statement {
    public BlockStatementList sl;

    public ABlockStatement(BlockStatementList sl, int ln){
        super(ln);
        this.sl = sl;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
