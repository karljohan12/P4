package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AFormalParameter extends ASTNode {

    public AFormalParameter(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}

