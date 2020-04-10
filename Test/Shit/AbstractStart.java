package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractStart extends ASTNode {
    public AbstractStart(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
