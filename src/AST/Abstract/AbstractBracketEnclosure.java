package AST.Abstract;

abstract public class AbstractBracketEnclosure extends ASTNode {
    public AbstractBracketEnclosure(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
