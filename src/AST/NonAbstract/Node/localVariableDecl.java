package AST.NonAbstract.Node;

public class localVariableDecl {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
