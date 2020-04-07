package AST.NonAbstract.Node;

public class EmptystmtWithoutSubstatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
