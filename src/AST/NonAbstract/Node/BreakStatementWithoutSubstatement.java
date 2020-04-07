package AST.NonAbstract.Node;

public class BreakStatementWithoutSubstatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
