package AST.NonAbstract.Node;

public class LocalVariableDeclStatement {
    public void accept(Visitor v) {
        v.visit(this);
    }
}
