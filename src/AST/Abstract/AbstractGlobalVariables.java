package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractGlobalVariables extends ASTNode {
    public AbstractGlobalVariables(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
