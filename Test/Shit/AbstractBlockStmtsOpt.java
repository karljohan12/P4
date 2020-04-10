package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBlockStmtsOpt extends ASTNode {
    public AbstractBlockStmtsOpt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
