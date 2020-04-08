package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractSwitchBlockStmtGroups extends ASTNode {
    public AbstractSwitchBlockStmtGroups(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
