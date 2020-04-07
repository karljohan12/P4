package AST.NonAbstract.Node;

public class ExprStmtWithoutSubstatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
