package AST.NonAbstract.Node;

public class NameExpression {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
