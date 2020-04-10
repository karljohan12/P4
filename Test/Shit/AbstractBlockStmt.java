package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBlockStmt extends ASTNode {
    public AbstractBlockStmt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
