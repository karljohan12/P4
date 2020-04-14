package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.List.BlockStatementList;
import AST.List.SwitchLabelList;
import AST.Visitor.Visitor;

public class SwitchLabelBlock extends Statement {
    public SwitchLabelList s;
    public BlockStatementList bs;

    public SwitchLabelBlock(SwitchLabelList s, BlockStatementList bs, int ln){
        super(ln);
        this.s = s;
        this.bs = bs;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
