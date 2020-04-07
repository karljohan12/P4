package AST.NonAbstract.Node;

public class ServoInitsStmt {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
