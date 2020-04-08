package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractAssignmentOperator extends ASTNode {
    public AbstractAssignmentOperator(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
