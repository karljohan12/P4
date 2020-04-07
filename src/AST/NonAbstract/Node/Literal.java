package AST.NonAbstract.Node;

public class Literal extends ASTNode {

    public void accept(Visitor v) {
        v.visit(this);
    }
}
