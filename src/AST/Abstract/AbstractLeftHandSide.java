package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractLeftHandSide extends ASTNode {
    public AbstractLeftHandSide(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
