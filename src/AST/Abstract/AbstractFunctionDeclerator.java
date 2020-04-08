package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFunctionDeclerator extends ASTNode {
    public AbstractFunctionDeclerator(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
