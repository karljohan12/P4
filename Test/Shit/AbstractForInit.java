package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractForInit extends ASTNode {
    public AbstractForInit(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
