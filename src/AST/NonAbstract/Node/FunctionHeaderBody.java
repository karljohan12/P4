package AST.NonAbstract.Node;

public class FunctionHeaderBody {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
