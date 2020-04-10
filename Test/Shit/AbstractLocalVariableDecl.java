package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractLocalVariableDecl extends ASTNode {
    public AbstractLocalVariableDecl(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
