package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractServoInits extends ASTNode {
    public AbstractServoInits(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
