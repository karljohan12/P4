package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractPrimaryNoNewArray extends ASTNode {
    public AbstractPrimaryNoNewArray(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
