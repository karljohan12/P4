package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFunctionStmts extends ASTNode {
    public AbstractFunctionStmts(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
