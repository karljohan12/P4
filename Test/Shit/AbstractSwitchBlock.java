package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractSwitchBlock extends ASTNode {
    public AbstractSwitchBlock(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
