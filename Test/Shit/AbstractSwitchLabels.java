package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractSwitchLabels extends ASTNode {
    public AbstractSwitchLabels(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
    }

