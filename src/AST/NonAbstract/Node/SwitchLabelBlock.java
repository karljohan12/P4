package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractBlockStmts;
import AST.Abstract.AbstractSwitchLabels;
import AST.NonAbstract.Nonterminal.SwitchBlockStmtGroup;
import AST.Visitor.Visitor;

public class SwitchLabelBlock extends ASTNode {

    public AbstractSwitchLabels sls;
    public AbstractBlockStmts bls;

    public SwitchLabelBlock(AbstractSwitchLabels asls, AbstractBlockStmts abls, int ln){
        super(ln);
        sls = asls;
        bls = abls;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
