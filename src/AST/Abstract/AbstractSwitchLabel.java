package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractSwitchLabel extends ASTNode {
    public AbstractSwitchLabel(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
