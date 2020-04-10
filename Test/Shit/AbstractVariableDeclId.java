package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractVariableDeclId extends ASTNode {
    public AbstractVariableDeclId(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
    }


