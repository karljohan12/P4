package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractGlobalVariables extends ASTNode {
    public AbstractGlobalVariables(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
