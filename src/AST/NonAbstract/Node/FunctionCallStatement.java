package AST.NonAbstract.Node;

public class FunctionCallStatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
