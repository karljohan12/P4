package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.NonAbstract.Nonterminal.SwitchStmt;
import AST.Visitor.Visitor;

public class SwitchStmtWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public SwitchStmt ss;


    public SwitchStmtWithoutSubstatement(SwitchStmt ass, int ln){
        super(ln);
        ss=ass;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
