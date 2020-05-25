package AST.Abstract;

import Interfaces.IVisitor;

abstract public class Type extends ASTNode {

    public Type(int ln) {
        super(ln);
    }
    public abstract void accept(IVisitor v);
}
