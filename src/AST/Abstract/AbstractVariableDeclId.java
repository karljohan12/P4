package AST.Abstract;

abstract public class AbstractVariableDeclId extends ASTNode {
    public AbstractVariableDeclId(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
