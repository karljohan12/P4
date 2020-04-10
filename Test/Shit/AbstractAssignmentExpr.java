package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractAssignmentExpr extends ASTNode {
    public AbstractAssignmentExpr(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);

}
