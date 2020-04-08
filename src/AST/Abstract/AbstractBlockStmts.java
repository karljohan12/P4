package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBlockStmts extends ASTNode {
    public AbstractBlockStmts(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
