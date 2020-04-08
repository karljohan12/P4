package AST.NonAbstract.Node;

import AST.Abstract.AbstractVariableInit;
import AST.Visitor.Visitor;


public class ServoInitStmt extends AbstractVariableInit {
    public ServoInitsStmt si;

    public ServoInitStmt(ServoInitsStmt si, int ln) {
        super(ln);
        this.si = si;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
