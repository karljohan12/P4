package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class LocalVariableDecl extends ASTNode{

    public LocalVariableDecl(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
