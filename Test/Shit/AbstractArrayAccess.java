package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractArrayAccess extends ASTNode {
    public AbstractArrayAccess(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
