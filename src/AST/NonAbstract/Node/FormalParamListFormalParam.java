package AST.NonAbstract.Node;

public class FormalParamListFormalParam {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
