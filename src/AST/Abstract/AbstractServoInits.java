package AST.Abstract;

abstract public class AbstractServoInits extends ASTNode {
    public AbstractServoInits(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
