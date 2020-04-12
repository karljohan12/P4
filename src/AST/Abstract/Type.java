package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class Type extends ASTNode {

    public Type(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
