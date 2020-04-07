package AST.NonAbstract.Node;

public class Ident {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
