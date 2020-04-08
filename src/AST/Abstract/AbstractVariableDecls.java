package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractVariableDecls extends ASTNode {
    public AbstractVariableDecls(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
