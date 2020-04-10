package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFunctionStmtsOpt extends ASTNode {
    public AbstractFunctionStmtsOpt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
