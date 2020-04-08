package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class SwitchStmtWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public Switch ss;


    public SwitchStmtWithoutSubstatement(Switch ass, int ln){
        super(ln);
        ss=ass;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
