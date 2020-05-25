package AST.Abstract;

import Interfaces.IVisitor;

abstract public class GlobalVariable extends ASTNode{

    public GlobalVariable(int ln) {
        super(ln);
    }
    public abstract void accept(IVisitor v);
}
