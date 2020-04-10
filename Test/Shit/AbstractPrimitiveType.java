package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractPrimitiveType extends ASTNode {
    public AbstractPrimitiveType(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
