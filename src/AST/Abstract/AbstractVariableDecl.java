package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractVariableDecl extends ASTNode {
    public AbstractVariableDecl(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
