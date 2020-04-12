package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class Program extends ASTNode{

    public Program(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
