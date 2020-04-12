package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class FunctionHeader extends ASTNode {

    public FunctionHeader(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
