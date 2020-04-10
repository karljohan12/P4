package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractNumericType extends ASTNode {
    public AbstractNumericType(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
