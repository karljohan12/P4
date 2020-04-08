package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBracketEnclosure extends ASTNode {
    public AbstractBracketEnclosure(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
