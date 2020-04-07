package AST.NonAbstract.Node;

public class ReturnStatementWithoutSubstatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
