package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractReferenceType extends ASTNode {
    public AbstractReferenceType(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
