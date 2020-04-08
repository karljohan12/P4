package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFunctionBody extends ASTNode {
    public AbstractFunctionBody(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
