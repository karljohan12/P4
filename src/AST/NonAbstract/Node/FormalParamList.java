package AST.NonAbstract.Node;

public class FormalParamList {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
