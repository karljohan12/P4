package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class Expression extends ASTNode {
    public Expression(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}


