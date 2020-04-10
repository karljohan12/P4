package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractArrayType extends ASTNode {
    public AbstractArrayType(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
