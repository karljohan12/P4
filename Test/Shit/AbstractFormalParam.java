package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFormalParam extends ASTNode {
    public AbstractFormalParam(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
