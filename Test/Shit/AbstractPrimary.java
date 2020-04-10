package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractPrimary extends ASTNode {
    public AbstractPrimary(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
