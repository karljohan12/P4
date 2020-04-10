package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractType extends ASTNode {
    public AbstractType(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
