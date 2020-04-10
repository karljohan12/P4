package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFunctionHeader extends ASTNode {
    public AbstractFunctionHeader(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
