package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractLiteral extends ASTNode {
    public AbstractLiteral(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
