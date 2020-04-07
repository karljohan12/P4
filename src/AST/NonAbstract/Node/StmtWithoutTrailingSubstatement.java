package AST.NonAbstract.Node;

public class StmtWithoutTrailingSubstatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
