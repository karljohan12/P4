package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableInit;
import AST.NonAbstract.Nonterminal.ServoInit;

public class ServoInitStmt extends AbstractVariableInit {
    public ServoInit si;

    public ServoInitStmt(ServoInit si, int ln) {
        super(ln);
        this.si = si;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
