package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.BlockStatementList;
import Interfaces.IVisitor;

public class ABlockStatement extends Statement {
    public BlockStatementList sl;

    public ABlockStatement(BlockStatementList sl, int ln){
        super(ln);
        this.sl = sl;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }

}
