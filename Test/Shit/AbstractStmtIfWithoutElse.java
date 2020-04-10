package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractStmtIfWithoutElse extends ASTNode {
    public AbstractStmtIfWithoutElse(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
