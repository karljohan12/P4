package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class GlobalVariable extends ASTNode{

    public GlobalVariable(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
